package co.edu.javeriana.mybot;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class WhileBot implements ASTNode{
	private ASTNode condition;
	private Viscera body;

	public WhileBot(ASTNode condition, Viscera body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		Object return_=null;
		while((boolean)this.condition.execute(symbolTable, null)){
			if(this.body!=null){
				return_=this.body.execute(symbolTable, programmData);
				if(return_!=null && return_ instanceof Return){
					return return_;
				}
			}
		}
		return null;
	}

}
