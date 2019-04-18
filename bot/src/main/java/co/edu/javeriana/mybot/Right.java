package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Right implements ASTNode {

	private ASTNode expression;
	
	public Right(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		try{
			programmData.getBot().right((int)((this.expression.execute(symbolTable, programmData))));
		} catch (Exception e) {
			System.err.println("Error en Right.");
			 System.exit(0);
		}
		return null;
	}

}
