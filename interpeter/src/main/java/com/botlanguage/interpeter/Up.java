package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Up implements ASTNode {

	private ASTNode expression;
	
	public Up(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		bot.up((int) expression.execute(symbolTable,bot));
		return null;
	}

}
