package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Left implements ASTNode {

	private ASTNode expression;
	
	public Left(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		try{
			programmData.getBot().down((int)((double)(this.expression.execute(symbolTable, programmData))));
		} catch (Exception e) {
			 System.err.println("-> ERROR en South la expresion no es posible castear a entero");
			 System.exit(0);
		}
		return null;
	}

}
