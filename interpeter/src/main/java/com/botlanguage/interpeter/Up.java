package com.botlanguage.interpeter;

import java.util.Map;
import java.util.Stack;

public class Up implements ASTNode {

	private ASTNode expression;
	
	public Up(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		// TODO Auto-generated method stub
		return null;
	}

}
