package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class WhileBot implements ASTNode{
	private ASTNode condition;
	private List<ASTNode> body;

	public WhileBot(ASTNode condition, List<ASTNode> body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		while((boolean) condition.execute(symbolTable, bot)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot);
			}
		} 
		return null;
	}

}
