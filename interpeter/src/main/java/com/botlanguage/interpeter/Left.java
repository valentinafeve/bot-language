package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Left implements ASTNode {

	private ASTNode expression;
	
	public Left(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		bot.left((int) expression.execute(symbolTable,bot));
		return null;
	}

}
