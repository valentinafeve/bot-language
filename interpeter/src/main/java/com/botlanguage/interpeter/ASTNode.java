package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public interface ASTNode {
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable);
}
