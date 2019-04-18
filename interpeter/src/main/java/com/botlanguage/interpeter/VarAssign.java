package com.botlanguage.interpeter;

import java.util.Map;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name,expression.execute(symbolTable));
		return null;
	}
}
