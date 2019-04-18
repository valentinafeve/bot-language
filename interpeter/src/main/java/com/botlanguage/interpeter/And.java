package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class And implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public And(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		return (boolean)operand1.execute(symbolTable, bot) && (boolean)operand2.execute(symbolTable, bot);
	}

}
