package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Pick implements ASTNode {
	
	public Pick() {
		super();
	}
	
	@Override
	public Object execute(Map<String, Object>  symbolTable, Bot bot) {
		return bot.pick();
	}
}
