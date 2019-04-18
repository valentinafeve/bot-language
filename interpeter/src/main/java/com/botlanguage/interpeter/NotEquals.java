package com.botlanguage.interpeter;

import java.util.Map;

public class NotEquals implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public NotEquals(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if(operand1.execute(symbolTable) instanceof Boolean && operand2.execute(symbolTable) instanceof Boolean)
			return (boolean)operand1.execute(symbolTable) != (boolean)operand2.execute(symbolTable);
		else if(operand1.execute(symbolTable) instanceof Integer && operand2.execute(symbolTable) instanceof Integer)
			return (int)operand1.execute(symbolTable) != (int)operand2.execute(symbolTable);
		else if(operand1.execute(symbolTable) instanceof Double && operand2.execute(symbolTable) instanceof Double)
			return (double)operand1.execute(symbolTable) != (double)(operand2.execute(symbolTable));
		else
			return !(operand1.execute(symbolTable).equals(operand2.execute(symbolTable)));
	}

}
