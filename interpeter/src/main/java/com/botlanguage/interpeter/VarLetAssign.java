package com.botlanguage.interpeter;

import java.util.Map;

public class VarLetAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarLetAssign(String value, ASTNode expression) {
		super();
		this.name = value;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name,null);
		symbolTable.put(name,expression.execute(symbolTable));
		return null;
	}
}
