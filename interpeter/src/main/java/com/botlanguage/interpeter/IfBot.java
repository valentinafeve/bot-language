package com.botlanguage.interpeter;

import java.util.HashMap;
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
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		Map<String,Object> newScope = new HashMap<String, Object>(); 
		symbolTable.add(newScope);
		
		if ((boolean) condition.execute(symbolTable, bot, functionTable)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot, functionTable);
			}
		} else if(!elseBody.isEmpty()){
			for(ASTNode n : elseBody) {
				n.execute(symbolTable, bot, functionTable);
			}
		}
		
		symbolTable.remove(symbolTable.size()-1);
		return null;
	}

}
