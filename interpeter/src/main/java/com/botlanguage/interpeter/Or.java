package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Or implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public Or(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		return (boolean)operand1.execute(symbolTable, bot, functionTable) || (boolean)operand2.execute(symbolTable, bot, functionTable);
	}

}
