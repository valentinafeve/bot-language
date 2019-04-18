package com.botlanguage.interpeter;

import java.util.Map;

public class DualPlus implements ASTNode {
	private String name;
	
	public DualPlus(String operand) {
		super();
		this.name = operand;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if(symbolTable.get(name) instanceof Integer)
			symbolTable.put(name,(int) symbolTable.get(name) + 1);
		else
			symbolTable.put(name,(double) symbolTable.get(name) + 1);
		return null;
	}

}
