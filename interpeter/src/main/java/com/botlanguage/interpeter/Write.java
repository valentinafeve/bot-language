package com.botlanguage.interpeter;

import java.util.Map;

public class Write implements ASTNode {
	private ASTNode data;

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		System.out.print(data.execute(symbolTable));
		return null;
	}

	public Write(ASTNode data) {
		super();
		this.data = data;
	}

}
