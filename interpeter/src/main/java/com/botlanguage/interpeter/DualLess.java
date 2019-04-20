package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class DualLess implements ASTNode {
	private String name;

	public DualLess(String operand) {
		super();
		this.name = operand;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {

		for(int i=1;i<=symbolTable.size();i++) {
			if(symbolTable.get(symbolTable.size()-i).containsKey(name)) {
				if(symbolTable.get(symbolTable.size()-i).get(name) instanceof Integer)
					symbolTable.get(symbolTable.size()-i).put(name,(int) symbolTable.get(symbolTable.size()-i).get(name) - 1);
				else
					symbolTable.get(symbolTable.size()-i).put(name,(double) symbolTable.get(symbolTable.size()-i).get(name) - 1);
				break;
			}
		}
		return null;
	}

}
