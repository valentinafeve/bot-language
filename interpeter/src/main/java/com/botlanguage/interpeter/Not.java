package com.botlanguage.interpeter;

import java.util.Map;

public class Not implements ASTNode {
	private ASTNode operand;
	
	public Not(ASTNode operand1) {
		super();
		this.operand = operand1;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return !(boolean)operand.execute(symbolTable);
	}

}
