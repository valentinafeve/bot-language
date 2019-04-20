package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Function implements ASTNode {
	
	String name;
	List<ASTNode> body; 
	List<String> parameters;
	ASTNode returnval;
	
	public Function(String name, List<ASTNode> body, List<String> parameters, ASTNode returnval) {
		super();
		this.name = name;
		this.body = body;
		this.parameters = parameters;
		this.returnval = returnval;
	}

	public String getName() {
		return name;
	}

	public List<ASTNode> getBody() {
		return body;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public ASTNode getReturnval() {
		return returnval;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {
		functionTable.put(name, this);
		return null;
	}

}
