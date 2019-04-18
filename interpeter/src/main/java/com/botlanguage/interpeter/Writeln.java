package com.botlanguage.interpeter;

import java.util.Map;

public class Writeln implements ASTNode {
	private ASTNode data;

	public Writeln(ASTNode data) {
		super();
		this.data = data;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		System.out.println(data.execute(symbolTable));
		return null;
	}
}
