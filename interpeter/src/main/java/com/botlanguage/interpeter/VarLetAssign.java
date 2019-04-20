package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarLetAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarLetAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		symbolTable.get(symbolTable.size()-1).put(name,null);
		symbolTable.get(symbolTable.size()-1).put(name,expression.execute(symbolTable, bot, functionTable));
		return null;
	}
}
