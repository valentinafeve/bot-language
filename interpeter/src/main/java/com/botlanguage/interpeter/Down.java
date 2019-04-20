package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Down implements ASTNode {

	private ASTNode expression;
	
	public Down(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		bot.down((int) expression.execute(symbolTable,bot, functionTable));
		return null;
	}

}
