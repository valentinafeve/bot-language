package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Greater implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public Greater(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		if(operand1.execute(symbolTable, programmData) instanceof Double && operand2.execute(symbolTable, programmData) instanceof Double)
			return (double)operand1.execute(symbolTable, programmData) > (double)operand2.execute(symbolTable, programmData);
		else
			return (int)operand1.execute(symbolTable, programmData) > (int)operand2.execute(symbolTable, programmData);
	}

}
