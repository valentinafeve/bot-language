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
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
