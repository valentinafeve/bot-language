package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Right implements ASTNode {

	private ASTNode expression;
	
	public Right(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		bot.right((int) expression.execute(symbolTable,bot, functionTable));
		return null;
	}

}
