package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Write implements ASTNode {
	private ASTNode data;

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		System.out.print(data.execute(symbolTable, bot, functionTable));
		return null;
	}

	public Write(ASTNode data) {
		super();
		this.data = data;
	}

}
