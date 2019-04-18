package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Write implements ASTNode {
	private ASTNode data;

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		System.out.print(data.execute(symbolTable, bot));
		return null;
	}

	public Write(ASTNode data) {
		super();
		this.data = data;
	}

}
