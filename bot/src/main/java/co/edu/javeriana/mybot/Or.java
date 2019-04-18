package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Or implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public Or(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		return (boolean)operand1.execute(symbolTable, programmData) || (boolean)operand2.execute(symbolTable, programmData);
	}

}
