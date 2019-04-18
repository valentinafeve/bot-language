package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public interface ASTNode {
	public Object execute(Map<String, Object> symbolTable, Bot bot);
}
