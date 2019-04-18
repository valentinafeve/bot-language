package com.botlanguage.interpeter;

import java.util.Map;

public class VarDecl implements ASTNode {
	
	private String name;
	
	public VarDecl(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name, null);
		return null;
	}
}
