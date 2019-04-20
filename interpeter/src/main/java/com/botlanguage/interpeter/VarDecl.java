package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarDecl implements ASTNode {
	
	private String name;
	
	public VarDecl(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		symbolTable.get(symbolTable.size()-1).put(name, null);
		return null;
	}
}
