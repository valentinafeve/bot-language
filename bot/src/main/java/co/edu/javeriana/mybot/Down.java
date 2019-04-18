package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Down implements ASTNode {

	private ASTNode expression;
	
	public Down(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		try{
			programmData.getBot().down((int)((this.expression.execute(symbolTable, programmData))));
		} catch (Exception e) {
			 System.err.println("Error en Down.");
			 e.printStackTrace();
			 System.exit(0);
		}
		return null;
	}

}
