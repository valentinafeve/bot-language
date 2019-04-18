package com.botlanguage.interpeter;

import java.util.Map;

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
	public Object execute(Map<String, Object> symbolTable) {
		if(operand1.execute(symbolTable) instanceof Integer && operand2.execute(symbolTable) instanceof Integer)
			return (int) Math.pow((int)operand1.execute(symbolTable), (int)operand2.execute(symbolTable));
		
		else if(operand1.execute(symbolTable) instanceof Integer && operand2.execute(symbolTable) instanceof Double)
			return (int) Math.pow((int) operand1.execute(symbolTable), (double)operand2.execute(symbolTable));
		
		else if(operand1.execute(symbolTable) instanceof Double && operand2.execute(symbolTable) instanceof Integer)
			return (int) Math.pow((double)operand1.execute(symbolTable), (int) operand2.execute(symbolTable));

		else
			return Math.pow((double)operand1.execute(symbolTable), (double)operand2.execute(symbolTable));
		
	}

}
