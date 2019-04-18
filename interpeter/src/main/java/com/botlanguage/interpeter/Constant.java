package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Constant implements ASTNode {
	
	private Object value;
	
	public Constant(Object value) {
		super();
		this.value = value;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		return value;
	}

}
