package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Writeln implements ASTNode {
	private ASTNode data;

	public Writeln(ASTNode data) {
		super();
		this.data = data;
	}
	
	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		System.out.println(data.execute(symbolTable, bot, functionTable));
		return null;
	}
}
