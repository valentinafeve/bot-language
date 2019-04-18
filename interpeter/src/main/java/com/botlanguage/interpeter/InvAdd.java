package com.botlanguage.interpeter;

import java.util.Map;

public class InvAdd implements ASTNode {
	private ASTNode operand1;
	
	public InvAdd(ASTNode operand1) {
		super();
		this.operand1 = operand1;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if(operand1.execute(symbolTable) instanceof Double)
			return -(double)operand1.execute(symbolTable);
		else
			return -(int)operand1.execute(symbolTable);
	}

}
