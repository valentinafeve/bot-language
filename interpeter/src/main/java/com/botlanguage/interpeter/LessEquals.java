package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class LessEquals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public LessEquals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		if(operand1.execute(symbolTable, bot) instanceof Integer && operand2.execute(symbolTable, bot) instanceof Integer)
			return (int)operand1.execute(symbolTable, bot) <= (int)operand2.execute(symbolTable, bot);
		else
			return (double)operand1.execute(symbolTable, bot) <= (double)(operand2.execute(symbolTable,bot));
		
	}

}
