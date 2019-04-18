package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarLetAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarLetAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		symbolTable.put(name,null);
		symbolTable.put(name,expression.execute(symbolTable, bot));
		return null;
	}
}
