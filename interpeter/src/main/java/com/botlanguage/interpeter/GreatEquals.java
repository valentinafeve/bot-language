package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class GreatEquals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public GreatEquals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		if(operand1.execute(symbolTable, bot, functionTable) instanceof Double && operand2.execute(symbolTable, bot, functionTable) instanceof Double)
			return (double)operand1.execute(symbolTable, bot, functionTable) >= (double)operand2.execute(symbolTable, bot, functionTable);
		else
			return (int)operand1.execute(symbolTable, bot, functionTable) >= (int)operand2.execute(symbolTable, bot, functionTable);
	}

}
