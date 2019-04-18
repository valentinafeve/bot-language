package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Drop implements ASTNode {
	
	public Drop() {
		super();
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		return bot.drop();
	}

}
