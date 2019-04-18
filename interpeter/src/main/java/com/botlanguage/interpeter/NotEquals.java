package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class NotEquals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public NotEquals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		if(operand1.execute(symbolTable, bot) instanceof Boolean && operand2.execute(symbolTable, bot) instanceof Boolean)
			return (boolean)operand1.execute(symbolTable, bot) != (boolean)operand2.execute(symbolTable, bot);
		else if(operand1.execute(symbolTable, bot) instanceof Integer && operand2.execute(symbolTable, bot) instanceof Integer)
			return (int)operand1.execute(symbolTable, bot) != (int)operand2.execute(symbolTable, bot);
		else if(operand1.execute(symbolTable, bot) instanceof Double && operand2.execute(symbolTable, bot) instanceof Double)
			return (double)operand1.execute(symbolTable, bot) != (double)(operand2.execute(symbolTable, bot));
		else
			return !(operand1.execute(symbolTable, bot).equals(operand2.execute(symbolTable, bot)));
	}

}
