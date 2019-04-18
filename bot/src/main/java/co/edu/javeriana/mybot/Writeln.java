package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Writeln implements ASTNode {
	private ASTNode data;

	public Writeln(ASTNode data) {
		super();
		this.data = data;
	}
	
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		System.out.println(data.execute(symbolTable, programmData));
		return null;
	}
}
