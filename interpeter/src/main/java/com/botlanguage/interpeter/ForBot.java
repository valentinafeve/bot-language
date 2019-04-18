package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class ForBot implements ASTNode{
	private ASTNode initializer;
	private ASTNode condition;
	private ASTNode ender;
	private List<ASTNode> body;

	public ForBot(ASTNode initializer, ASTNode condition, ASTNode ender, List<ASTNode> body) {
		super();
		this.initializer = initializer;
		this.condition = condition;
		this.ender = ender;
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		initializer.execute(symbolTable, bot);
		while((boolean) condition.execute(symbolTable, bot)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot);
			}
			ender.execute(symbolTable, bot);
		} 
		return null;
	}

}
