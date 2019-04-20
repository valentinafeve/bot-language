package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;

	public VarAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		for(int i=1;i<=symbolTable.size();i++) {
			if(symbolTable.get(symbolTable.size()-i).containsKey(name)) {
				symbolTable.get(symbolTable.size()-i).put(name,expression.execute(symbolTable, bot, functionTable));
				break;
			}
		}
		return null;
	}
}
