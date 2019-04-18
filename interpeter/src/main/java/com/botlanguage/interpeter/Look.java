package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Look implements ASTNode {
	
	public Look() {
		super();
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		return bot.look();
	}

}
