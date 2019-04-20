package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Equals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;

	public Equals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		if(operand1.execute(symbolTable, bot, functionTable) instanceof Boolean && operand2.execute(symbolTable, bot, functionTable) instanceof Boolean)
			return (boolean)operand1.execute(symbolTable, bot, functionTable) == (boolean)operand2.execute(symbolTable, bot, functionTable);
		else if(operand1.execute(symbolTable, bot, functionTable) instanceof Integer && operand2.execute(symbolTable, bot, functionTable) instanceof Integer)
			return (int)operand1.execute(symbolTable, bot, functionTable) == (int)operand2.execute(symbolTable, bot, functionTable);
		else if(operand1.execute(symbolTable, bot, functionTable) instanceof Double && operand2.execute(symbolTable, bot, functionTable) instanceof Double)
			return (double)operand1.execute(symbolTable, bot, functionTable) == (double)(operand2.execute(symbolTable, bot, functionTable));
		else
			return operand1.execute(symbolTable, bot, functionTable).equals(operand2.execute(symbolTable, bot, functionTable));	
	}

}
