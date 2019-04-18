package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class VarDecl implements ASTNode {
	
	private String name;
	private ASTNode data;
	
	public VarDecl(String name, ASTNode value) {
		super();
		this.name = name;
		this.data = data;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		if(symbolTable.peek().containsKey(this.name)){	
			System.err.println("Ya existe una variable con el nombre.");
			System.exit(0);
		}
		
		if(this.data instanceof Constant){
			symbolTable.peek().put(this.name, this.data.execute(symbolTable, programmData));
		}else{
			symbolTable.peek().put(this.name, 0);
			this.data.execute(symbolTable, programmData);
		}
		return null;
	}
}
