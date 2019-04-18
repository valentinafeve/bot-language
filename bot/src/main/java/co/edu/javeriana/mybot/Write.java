package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Write implements ASTNode {
	private ASTNode data;

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		System.out.print(data.execute(symbolTable, programmData));
		return null;
	}

	public Write(ASTNode data) {
		super();
		this.data = data;
	}

}
