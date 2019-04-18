package co.edu.javeriana.mybot;
import java.util.Map;
import java.util.Stack;

public class VarLetAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarLetAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		Object expressionResult=this.expression.execute(symbolTable, programmData);
		
		if(this.expression instanceof Constant){
			symbolTable.peek().put(this.name, this.expression.execute(symbolTable, programmData));
		}else{
			symbolTable.peek().put(this.name, 0);
			this.expression.execute(symbolTable, programmData);
		}
		
		for(int i=symbolTable.size()-1;i>=0;i--){
			if (symbolTable.get(i).containsKey(this.name)){
				symbolTable.get(i).put(this.name,expressionResult );
				return null;
			}
		}
		System.err.println("-> ERROR la variable "+this.name+" no fue declarada");
		System.exit(0);
		return null;
	}
}
