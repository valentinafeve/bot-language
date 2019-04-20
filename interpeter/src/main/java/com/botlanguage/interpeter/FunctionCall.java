package com.botlanguage.interpeter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class FunctionCall implements ASTNode {

	String name;
	List<ASTNode> parameters;
	ASTNode returnval;

	public FunctionCall(String name, List<ASTNode> parameters) {
		super();
		this.name = name;
		this.parameters = parameters;
	}



	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {

		List<ASTNode> funcBody = functionTable.get(name).getBody(); 
		List<String> funcParameters = functionTable.get(name).getParameters();
		ASTNode returnval = functionTable.get(name).getReturnval();

		if(funcParameters.size() != parameters.size()) { 
			System.err.println("Undefined function parameters.");
			return null;
		}

		List<Map<String,Object>> functionScope = new ArrayList<Map<String,Object>>();
		Map<String,Object> newScope = new HashMap<String,Object>();
		functionScope.add(newScope);
		
		for(int i=0;i<parameters.size();i++) {
			ASTNode n = parameters.get(i);
			String value = funcParameters.get(i);
			VarLetAssign initialization = new VarLetAssign(value, n);
			initialization.execute(functionScope, bot, functionTable);
		}

		for(ASTNode n : funcBody) {
			n.execute(functionScope, bot, functionTable);
		}

		
		if(returnval == null)  
			return null;
		else 
			return returnval.execute(functionScope, bot, functionTable);

	}

}
