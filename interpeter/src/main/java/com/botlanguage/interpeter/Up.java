package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Up implements ASTNode {

	private ASTNode expression;
	
	public Up(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		bot.up((int) expression.execute(symbolTable,bot, functionTable));
		return null;
	}

}
