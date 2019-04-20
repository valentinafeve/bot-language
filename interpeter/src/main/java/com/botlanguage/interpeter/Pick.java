package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Pick implements ASTNode {
	
	public Pick() {
		super();
	}
	
	@Override
	public Object execute(List<Map<String,Object>>  symbolTable, Bot bot, Map<String, Function> functionTable) {
		return bot.pick();
	}
}
