package com.botlanguage.interpeter;

import java.util.HashMap;
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
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		
		Map<String,Object> newScope = new HashMap<String, Object>(); 
		symbolTable.add(newScope);
		
		
		while((boolean) condition.execute(symbolTable, bot, functionTable)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot, functionTable);
			}
		} 
		
		symbolTable.remove(symbolTable.size()-1);
		return null;
	}

}
