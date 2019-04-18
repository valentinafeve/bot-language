package com.botlanguage.interpeter;

import java.util.Map;

public class VarRef implements ASTNode {
	
private String name;
	
	public VarRef(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return symbolTable.get(name);
	}

}
