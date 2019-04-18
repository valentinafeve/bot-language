package com.botlanguage.interpeter;

import java.util.List;
import java.util.Map;

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
	public Object execute(Map<String, Object> symbolTable) {
		initializer.execute(symbolTable);
		while((boolean) condition.execute(symbolTable)) {
			for(ASTNode n : body) {
				n.execute(symbolTable);
			}
			ender.execute(symbolTable);
		} 
		return null;
	}

}
