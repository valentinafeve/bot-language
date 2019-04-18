package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgrammData programmData) {
		Object expressionResult=this.expression.execute(symbolTables, programmData);
		for(int i=symbolTables.size()-1;i>=0;i--){
			if (symbolTables.get(i).containsKey(this.name)){
				symbolTables.get(i).put(this.name,expressionResult );
				return null;
			}
		}
		System.err.println("La variable "+this.name+" no ha sido declarada.");
		System.exit(0);
		return null;
	}
}
