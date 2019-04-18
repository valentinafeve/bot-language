package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Not implements ASTNode {
	private ASTNode operand;
	
	public Not(ASTNode operand1) {
		super();
		this.operand = operand1;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		return !(boolean)operand.execute(symbolTable, programmData);
	}

}
