grammar Bot;

@parser::header{
	import java.util.Map;
	import java.util.HashMap;
	import java.lang.Math;
	import org.jpavlich.bot.*;
	import co.edu.javeriana.bot.*;
	import co.edu.javeriana.mybot.*;
}

@parser::members{
	private Bot bot;
	Map<String, ASTNode> symbolTable = new HashMap<String, ASTNode>();
	public BotParser(TokenStream input, Bot bot) {
	    this(input);
	    this.bot = bot;
	}
}

// No tocar, cualquier cambio lo hace estallar
programm: {
			ProgrammData programmData = new ProgrammData(bot);
			List<ASTNode> sentences=new ArrayList<ASTNode>();
		}
		(s1=sentence{sentences.add($s1.node);})*
		{
			for(ASTNode n:sentences){
				n.execute(programmData.getSymbolTables(),programmData);
			}
		}
		;

sentence returns [ASTNode node] : 
		function {$node =$function.node;}|
		functioncall {$node=$functioncall.node;}|
		vardecl {$node=$vardecl.node;}| 
		varassign {$node=$varassign.node;}|
		writeln {$node=$writeln.node;}|
		write {$node=$write.node;}|
		read {$node=$read.node;}| 
		pick {$node=$pick.node;}| 
		drop {$node=$drop.node;}| 
		look {$node=$look.node;}| 
		up {$node=$up.node;}| 
		down {$node=$down.node;}| 
		left {$node=$left.node;}| 
		right {$node=$right.node;}|
		whilebot{$node=$whilebot.node;}|
		ifbot{$node=$ifbot.node;}	
;

viscera returns [Viscera body]:
			{
				$body=new Viscera();
			}
			(s1=sentence{$body.add($s1.node);})*
			;

//-----------------------------------------------------------------------------------
// 1.	Comandos del robot

pick returns[ASTNode node] : PICK SEMICOLON
								{$node=new Pick();}
								;
drop returns[ASTNode node] : DROP SEMICOLON
								{$node=new Drop();}
								;
look returns[ASTNode node] : LOOK SEMICOLON
								{$node=new Look();}
								;

up returns[ASTNode node] : UP expression SEMICOLON
								{$node=new Up($expression.node);}
								;
								
down returns[ASTNode node] : DOWN expression SEMICOLON
								{$node=new Down($expression.node);}
								;
																
left returns[ASTNode node] :LEFT expression SEMICOLON
								{$node=new Left($expression.node);}
								;
								
right returns[ASTNode node] : RIGHT expression SEMICOLON
								{$node=new Right($expression.node);}
								;	
								
//-----------------------------------------------------------------------------------
// 2. Variables

vardecl returns [ASTNode node]: LET (
								(ID{$node=new VarDecl($ID.text,new Constant(0));} SEMICOLON)
								| 
								(ID EQUAL expression SEMICOLON {$node=new VarDecl($ID.text,new VarAssign($ID.text,$expression.node));})
								);
								
								
								
varassign returns [ASTNode node]: ID EQUAL
		(
		 expression SEMICOLON {$node=new VarAssign($ID.text,$expression.node);} 
		 )
;
	
//-----------------------------------------------------------------------------------
// 3. Constantes y tipos de datos			

term returns [ASTNode node]: 
	DECIMAL {$node = new Constant(Double.parseDouble($DECIMAL.text));}
	|
	NUMBER {$node = new Constant(Integer.parseInt($NUMBER.text));}
	|
	BOOLEAN	{$node = new Constant(Boolean.parseBoolean($BOOLEAN.text));}
	|
	ID	{$node = new VarRef($ID.text);} 
	| 
	WORD {$node = new Constant($WORD.text.substring(1,$WORD.text.length()-1));}
	|
	ORBRACKET condition {$node = $condition.node;} CRBRACKET
;

//-----------------------------------------------------------------------------------
// 4. Condicionales

ifbot returns [ASTNode node]: 	
	IF ORBRACKET condition CRBRACKET
		BEGIN
		(body=viscera)
		END SEMICOLON
		(
			ELSE (elsebody=viscera) SEMICOLON
			 {
			 	$node=new IfBot($condition.node,$body.body,$elsebody.body);
			 }
		 )?		  
;

//-----------------------------------------------------------------------------------
// 5. Ciclos

whilebot  returns [ASTNode node]: 
	WHILE ORBRACKET condition CRBRACKET 
	BEGIN 
		viscera 
	END SEMICOLON
	{
		$node = new WhileBot($condition.node,$viscera.body);
	}
;
			
forbot returns [ASTNode node]: 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	FOR ORBRACKET init SEMICOLON condition SEMICOLON ender CRBRACKET 
	BEGIN 
		(sentence)* 
	END SEMICOLON
	{
		//$node = new ForBot($init.node,$condition.node,$ender.node,body);
	}
;

init returns [ASTNode node]: 
	varassign {$node = $varassign.node;} | vardecl {$node = $vardecl.node;}
;

ender returns [ASTNode node]:
	(varassign {$node = $varassign.node;})
	|
	(dualop {$node = $dualop.node;})
;

dualop returns [ASTNode node]: 
	(ID DUALPLUS {$node = new DualPlus($ID.text);})
	|
	(ID DUALMINUS {$node = new DualLess($ID.text);})
;

//-----------------------------------------------------------------------------------
// 6. Impresion y lectura por pantalla

writeln returns [ASTNode node]: 
	WRITELN expression {$node = new Writeln($expression.node);} SEMICOLON
;

write returns [ASTNode node]: 
	WRITE expression {$node = new Write($expression.node) ;} SEMICOLON 
;

read returns [ASTNode node]: 
	READ ID {$node = new Read($ID.text);} SEMICOLON
;

//-----------------------------------------------------------------------------------
// 7. Expresiones aritméticas
expression returns [ASTNode node]: 
	t1=factor{$node = $t1.node;}
	(
		(PLUS t2=factor{$node = new Addition($node, $t2.node);})
		|
		(MINUS t2=factor{$node = new Subtraction($node, $t2.node);})
	)*
;
			
factor returns [ASTNode node]:	
	t1=pow {$node = $t1.node;}
	(
		(MULT t2=pow{$node = new Multiplication($node, $t2.node);})
		|
		(DIV t2=pow{$node = new Division($node, $t2.node);})
	)*
;
		
pow returns [ASTNode node]: 
	t1=inverse {$node = $t1.node;} (POW t2=inverse {$node = new Pow($node,$t2.node);})*
;

inverse returns [ASTNode node]:
	(MINUS term {$node = new InvAdd($term.node);}) | (term) {$node = $term.node;}
;

//-----------------------------------------------------------------------------------
// 8. y 9. Expresiones lógicas y Expresiones de Comparación
condition returns [ASTNode node]: 
	(c1=expression {$node = $c1.node;} (
		(NOTEQ c2=expression {$node = new NotEquals($node,$c2.node);})
		|
		(EQUALS c2=expression  {$node = new Equals($node,$c2.node);})
		|
		(GREQ c2=expression  {$node = new GreatEquals($node,$c2.node);})
		|
		(LSEQ c2=expression  {$node = new LessEquals($node,$c2.node);})
		|
		(GREAT c2=expression  {$node = new Greater($node,$c2.node);})
		|
		(LESS c2=expression  {$node = new Lesser($node,$c2.node);})
		|
		(AND c2=expression  {$node = new And($node,$c2.node);})
		|
		(OR c2=expression  {$node = new Or($node,$c2.node);})
	)*)
	|
	NOT expression {$node = new Not($expression.node);}
;

//-----------------------------------------------------------------------------------
// 10. Declaración de funciones
function returns [ASTNode node]: {
			
		}
		FUNCTION ID ORBRACKET input_function CRBRACKET BEGIN viscera END SEMICOLON
		{
			$node = new Function($ID.text,$input_function.parameters,$viscera.body);
		}
;

//-----------------------------------------------------------------------------------
// 11. Invocación de funciones
			
input_function returns [List<String> parameters]: 
				{
					$parameters=new ArrayList<String>();
				}
				in1=input{$parameters.add($in1.var_name);} 
				(COMMA in2=input{$parameters.add($in2.var_name);})*;

input returns [String var_name]: LET ID{$var_name=$ID.text;};

functioncall returns [ASTNode node]:
			{
				List<ASTNode> expressions=new ArrayList<ASTNode>();
			}
			ID ORBRACKET (e1=expression{expressions.add($e1.node);} (COMMA e2=expression{expressions.add($e2.node);})*)* CRBRACKET SEMICOLON
			{
				$node = new FunctionCall($ID.text,expressions);
			}
			;


//-----------------------------------------------------------------------------------
// TOKENS
//Bot actions
UP: 'up';
DOWN: 'down';
RIGHT: 'right';
LEFT: 'left';
LOOK: 'look';
PICK: 'pick';
DROP: 'drop';

//Reserved words
FUNCTION: 'function';
END: 'end';
BEGIN: 'begin';
WRITELN: 'writeln';
WRITE: 'write';
READ: 'read';
LET: 'let';
WHILE: 'while';
FOR: 'for';
IF: 'if';
ELSE: 'else';
ELIF: 'elif';

//Signs
SEMICOLON:';';
COMMA:',';
//Round brackets, Square brackets
ORBRACKET:'(';
CRBRACKET:')';
OSBRACKET:'(';
CSBRACKET:')';

NOTEQ: '!=' | '<>';
EQUALS:'==';
GREQ:  '>=';
LSEQ:  '<=';
GREAT:  '>';
LESS:   '<';
AND:  'and';
OR:    'or';
NOT:    '!';

DUALPLUS: '++';
DUALMINUS: '--';
PLUS:'+';
MINUS:'-';
MULT: '*';
DIV:'/';
POW:'^';

EQUAL:'=';
BOOLEAN: 'true' | 'false';
WORD: '"'[a-zA-Z0-9\t\r\n ]*'"';
DECIMAL: [0-9]+'.'[0-9]+;
NUMBER: [0-9]+;
ID:[a-zA-Z_][a-zA-Z0-9_]*;

WS
:
	[ \t\r\n]+ -> skip
;