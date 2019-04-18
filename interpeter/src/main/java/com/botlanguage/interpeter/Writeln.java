package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Writeln implements ASTNode {
	private ASTNode data;

	public Writeln(ASTNode data) {
		super();
		this.data = data;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		System.out.println(data.execute(symbolTable, bot));
		return null;
	}
}
