package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class InvAdd implements ASTNode {
	private ASTNode operand1;
	
	public InvAdd(ASTNode operand1) {
		super();
		this.operand1 = operand1;
	}
	
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		if(operand1.execute(symbolTable, programmData) instanceof Double)
			return -(double)operand1.execute(symbolTable, programmData);
		else
			return -(int)operand1.execute(symbolTable, programmData);
	}

}
