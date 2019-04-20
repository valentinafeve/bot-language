grammar bot;

@parser::header{
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.HashMap;
	import java.lang.Math;
	import org.jpavlich.bot.*;
}

@parser::members{
	private Bot bot;
	List<Map<String, ASTNode>> symbolTable = new ArrayList<Map<String, ASTNode>>();
	public botParser(TokenStream input, Bot bot) {
	    this(input);
	    this.bot = bot;
	}	
}

// No tocar, cualquier cambio lo hace estallar
programm: 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
		List<Map<String,Object>> symbolTable = new ArrayList<Map<String,Object>>();
		Map<String,Function> functionTable = new HashMap<String,Function>();
		
		Map<String,Object> defSymbol = new HashMap<String,Object>();
		symbolTable.add(defSymbol);
	}
	(sentence {body.add($sentence.node);})*
	{
		for(ASTNode n : body){
			n.execute(symbolTable, bot, functionTable);
		}	
	}
;


// Lista TO-DO (Lo comentado y alcance de variables):
sentence returns [ASTNode node]:
	(up {$node=$up.node;} SEMMICOLON) | 
	(down {$node=$down.node;} SEMMICOLON) | 
	(left {$node=$left.node;} SEMMICOLON) | 
	(right {$node=$right.node;} SEMMICOLON) |
	(pick {$node=$pick.node;} SEMMICOLON) | 
	(drop {$node=$drop.node;} SEMMICOLON) | 
	(look {$node=$look.node;} SEMMICOLON) |
	(vardecl {$node = $vardecl.node;} SEMMICOLON) | 
	(varassign {$node = $varassign.node;} SEMMICOLON) |
	(vardeclassign {$node = $vardeclassign.node;} SEMMICOLON) |
	(dualop {$node = $dualop.node;} SEMMICOLON) |
	(ifbot {$node = $ifbot.node;}) |
	(forbot {$node = $forbot.node;}) |
	(whilebot {$node = $whilebot.node;}) | 
	(writeln {$node = $writeln.node;} SEMMICOLON) |
	(write {$node = $write.node;} SEMMICOLON) |
	(read {$node = $read.node;} SEMMICOLON) |
	(function {$node = $function.node;}) |
	(returncall {$node = $returncall.node;} SEMMICOLON) |
	(functioncall {$node=$functioncall.node;} SEMMICOLON)
;

//-----------------------------------------------------------------------------------
// 1.	Comandos del robot

up returns[ASTNode node] : 
	UP expression {$node=new Up($expression.node);}
;
								
down returns[ASTNode node] : 
	DOWN expression {$node=new Down($expression.node);}
;
																
left returns[ASTNode node] :
	LEFT expression {$node=new Left($expression.node);}
;
								
right returns[ASTNode node] : 
	RIGHT expression {$node=new Right($expression.node);}
;	

pick returns[ASTNode node] : 
	PICK {$node=new Pick();}
;

drop returns[ASTNode node] : 
	DROP {$node=new Drop();}
;

look returns[ASTNode node] : 
	LOOK {$node=new Look();}
;

action returns [ASTNode node]:
;

//-----------------------------------------------------------------------------------
// 2. Variables

vardeclassign returns [ASTNode node]: 
	LET ID EQUAL orexp { $node = new VarLetAssign($ID.text, $orexp.node);}
;

vardecl returns [ASTNode node]: 
	LET ID {$node = new VarDecl($ID.text);}
;
	
varassign returns [ASTNode node]: 
	ID EQUAL orexp {$node = new VarAssign($ID.text, $orexp.node);}
;

dualop returns [ASTNode node]: 
	(ID DUALPLUS {$node = new DualPlus($ID.text);})
	|
	(ID DUALMINUS {$node = new DualLess($ID.text);})
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
	( ORBRACKET orexp {$node = $orexp.node;} CRBRACKET )
;

//-----------------------------------------------------------------------------------
// 4. Condicionales

ifbot returns [ASTNode node]: 	
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
		List<ASTNode> elseBody = new ArrayList<ASTNode>();
	}
	IF ORBRACKET orexp CRBRACKET
	BEGIN 
		(s1=sentence {body.add($s1.node);})* 
	END SEMMICOLON 
	(ELSE BEGIN 
		(s2=sentence {elseBody.add($s2.node);})*
	END SEMMICOLON)?
	{$node = new IfBot($orexp.node,body,elseBody);}
	
	/*
	(
		IF ORBRACKET expression CRBRACKET 
		BEGIN sentence+ (END SEMMICOLON
		ELIF BEGIN sentence+)* END SEMMICOLON 
	) 
	| 
	(
		IF ORBRACKET expression CRBRACKET 
		BEGIN sentence+ (END SEMMICOLON 
		ELIF BEGIN sentence+)* END SEMMICOLON 
		ELSE BEGIN sentence+ END SEMMICOLON 
	)*/
;



//-----------------------------------------------------------------------------------
// 5. Ciclos

// Partes de un ciclo: condicion, sentencias, incremento** Para el for
whilebot returns [ASTNode node]: 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	WHILE ORBRACKET orexp CRBRACKET 
	BEGIN 
		(sentence {body.add($sentence.node);})*
	END SEMMICOLON
	{$node = new WhileBot($orexp.node,body);}
;

forbot returns [ASTNode node]: 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	FOR ORBRACKET init SEMMICOLON orexp SEMMICOLON ender CRBRACKET 
	BEGIN 
		(sentence {body.add($sentence.node);})*
	END SEMMICOLON
	{$node = new ForBot($init.node,$orexp.node,$ender.node,body);}
;

init returns [ASTNode node]: 
	varassign {$node = $varassign.node;} | vardeclassign {$node = $vardeclassign.node;}
;

ender returns [ASTNode node]:
	(varassign {$node = $varassign.node;})
	|
	(dualop {$node = $dualop.node;})
;

//-----------------------------------------------------------------------------------
// 6. Impresion y lectura por pantalla

writeln returns [ASTNode node]: 
	WRITELN expression {$node = new Writeln($expression.node);}
;

write returns [ASTNode node]: 
	WRITE expression {$node = new Write($expression.node);} 
;

read returns [ASTNode node]: 
	READ ID {$node = new Read($ID.text);}
;

//-----------------------------------------------------------------------------------
// 7. Expresiones aritméticas

expression returns [ASTNode node]: 
	(
		t1=factor{$node = $t1.node;}
		(
			(PLUS t2=factor{$node = new Addition($node, $t2.node);})
			|
			(MINUS t2=factor{$node = new Subtraction($node, $t2.node);})
		)* 
	)
	|
	look {$node = $look.node;} 
	| 
	drop {$node = $drop.node;} 
	| 
	pick {$node = $pick.node;}
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
// 8. Expresiones lógicas

explogical returns [ASTNode node]:
	comparation {$node = $comparation.node;}  
	|
	(NOT comparation {$node = new Not($comparation.node);})
;

andexp returns [ASTNode node]:
	e1=explogical {$node = $e1.node;} (
		AND e2=explogical {$node = new And($node,$e2.node);}	
	)*
;

orexp returns [ASTNode node]:
	e1=andexp {$node = $e1.node;} (
		OR e2=andexp {$node = new Or($node,$e2.node);}
	)*
;
 
//-----------------------------------------------------------------------------------
// 9. Expresiones de Comparación

comparation returns [ASTNode node]:
	c1=expression {$node = $c1.node;} (
		(NOTEQ c2=expression {$node = new NotEquals($node,$c2.node);})
		|
		(EQUALS c2=expression {$node = new Equals($node,$c2.node);})
		|
		(GREQ c2=expression {$node = new GreatEquals($node,$c2.node);})
		|
		(LSEQ c2=expression {$node = new LessEquals($node,$c2.node);})
		|
		(GREAT c2=expression {$node = new Greater($node,$c2.node);})
		|
		(LESS c2=expression  {$node = new Lesser($node,$c2.node);})	
	)*		
;

//-----------------------------------------------------------------------------------
// 10. Declaración de funciones

function returns [ASTNode node]: 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
		List<String> parameters = new ArrayList<String>();
		ASTNode returnval = null;
	}
	FUNCTION name=ID ORBRACKET (LET param=ID {parameters.add($param.text);})* CRBRACKET
	BEGIN 
		(s=sentence {body.add($s.node);})* 
		(RETURN expression SEMMICOLON {returnval = $expression.node;})? 
	END SEMMICOLON
	{$node = new Function($name.text, body, parameters, returnval);}
;

//-----------------------------------------------------------------------------------
// 11. Invocación de funciones

returncall returns [ASTNode node]:
	(ID EQUAL functioncall {$node = new VarAssign($ID.text,$functioncall.node);})
	|
	(LET ID EQUAL functioncall {$node = new VarLetAssign($ID.text,$functioncall.node);})
;

functioncall returns [ASTNode node]: 
	{
		List<ASTNode> parameters = new ArrayList<ASTNode>();
	}
	ID ORBRACKET (p1=expression? {parameters.add($p1.node);} (COMMA p2=expression {parameters.add($p2.node);})*) CRBRACKET
	{$node = new FunctionCall($ID.text,parameters);}
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
RETURN: 'return';

//Signs
SEMMICOLON:';';
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