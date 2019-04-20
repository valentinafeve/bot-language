package com.botlanguage.interpeter;

import java.util.HashMap;
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
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		Map<String,Object> newScope = new HashMap<String, Object>(); 
		symbolTable.add(newScope);

		initializer.execute(symbolTable, bot, functionTable);
		while((boolean) condition.execute(symbolTable, bot, functionTable)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, bot, functionTable);
			}
			ender.execute(symbolTable, bot, functionTable);
		}
		
		symbolTable.remove(symbolTable.size()-1);
		return null;
	}

}
