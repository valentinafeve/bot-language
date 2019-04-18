package com.botlanguage.interpeter;

import java.util.Map;

public class GreatEquals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public GreatEquals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if(operand1.execute(symbolTable) instanceof Double && operand2.execute(symbolTable) instanceof Double)
			return (double)operand1.execute(symbolTable) >= (double)operand2.execute(symbolTable);
		else
			return (int)operand1.execute(symbolTable) >= (int)operand2.execute(symbolTable);
	}

}
