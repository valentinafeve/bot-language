package com.botlanguage.interpeter;

import java.util.Map;
import java.util.Stack;

public class Left implements ASTNode {

	private ASTNode expression;
	
	public Left(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programInfo){
		// TODO Auto-generated method stub
		return null;
	}

}
