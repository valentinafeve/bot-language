package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		symbolTable.put(name,expression.execute(symbolTable, bot));
		return null;
	}
}
