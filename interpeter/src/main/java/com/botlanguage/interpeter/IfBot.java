package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class IfBot implements ASTNode{
	private ASTNode condition;
	private List<ASTNode> body;
	private List<ASTNode> elseBody;


	public IfBot(ASTNode condition, List<ASTNode> body, List<ASTNode> elseBody) {
		super();
		this.condition = condition;
		this.body = body;
		this.elseBody = elseBody;
	}


	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		if ((boolean) condition.execute(symbolTable, bot)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot);
			}
		} else if(!elseBody.isEmpty()){
			for(ASTNode n : elseBody) {
				n.execute(symbolTable, bot);
			}
		}
		return null;
	}

}
