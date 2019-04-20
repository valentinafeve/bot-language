package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarRef implements ASTNode {
	
private String name;
	
	public VarRef(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		for(int i=1;i<=symbolTable.size();i++) {
			if(symbolTable.get(symbolTable.size()-i).containsKey(name)) {
				return symbolTable.get(symbolTable.size()-i).get(name);
			}
		}
		return null;
	}

}
