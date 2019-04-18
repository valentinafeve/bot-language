package co.edu.javeriana.mybot;

import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		if ((boolean) condition.execute(symbolTable, programmData)) {
			for(ASTNode n : body) {
				n.execute(symbolTable, programmData);
			}
		} else if(!elseBody.isEmpty()){
			for(ASTNode n : elseBody) {
				n.execute(symbolTable, programmData);
			}
		}
		return null;
	}

}
