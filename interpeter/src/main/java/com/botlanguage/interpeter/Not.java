package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Not implements ASTNode {
	private ASTNode operand;
	
	public Not(ASTNode operand1) {
		super();
		this.operand = operand1;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		return !(boolean)operand.execute(symbolTable, bot, functionTable);
	}

}
