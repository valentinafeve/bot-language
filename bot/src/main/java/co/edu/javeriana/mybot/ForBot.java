package co.edu.javeriana.mybot;

import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		initializer.execute(symbolTable, programmData);
		while((boolean) condition.execute(symbolTable, programmData)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, programmData);
			}
			ender.execute(symbolTable, programmData);
		} 
		return null;
	}

}
