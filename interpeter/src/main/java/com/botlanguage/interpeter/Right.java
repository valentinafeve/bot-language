package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Right implements ASTNode {

	private ASTNode expression;
	
	public Right(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		bot.right((int) expression.execute(symbolTable,bot));
		return null;
	}

}
