package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Pow implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	public Pow(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		for(int i=0;i<10;i++) {
			
		}
	}
	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		if(operand1.execute(symbolTable, bot, functionTable) instanceof Integer && operand2.execute(symbolTable, bot, functionTable) instanceof Integer)
			return (int) Math.pow((int)operand1.execute(symbolTable, bot, functionTable), (int)operand2.execute(symbolTable, bot, functionTable));
		
		else if(operand1.execute(symbolTable, bot, functionTable) instanceof Integer && operand2.execute(symbolTable, bot, functionTable) instanceof Double)
			return (int) Math.pow((int) operand1.execute(symbolTable, bot, functionTable), (double)operand2.execute(symbolTable, bot, functionTable));
		
		else if(operand1.execute(symbolTable, bot, functionTable) instanceof Double && operand2.execute(symbolTable, bot, functionTable) instanceof Integer)
			return (int) Math.pow((double)operand1.execute(symbolTable, bot, functionTable), (int) operand2.execute(symbolTable, bot, functionTable));

		else
			return Math.pow((double)operand1.execute(symbolTable, bot, functionTable), (double)operand2.execute(symbolTable, bot, functionTable));
		
	}

}
