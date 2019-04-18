package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Subtraction implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	public Subtraction(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		if(operand1.execute(symbolTable, programmData) instanceof Double && operand2.execute(symbolTable, programmData) instanceof Double)
			return (double)operand1.execute(symbolTable, programmData) - (double)operand2.execute(symbolTable, programmData);
		
		else if(operand1.execute(symbolTable, programmData) instanceof Integer && operand2.execute(symbolTable, programmData) instanceof Double)
			return Double.valueOf((int) operand1.execute(symbolTable, programmData)) - (double)operand2.execute(symbolTable, programmData);
		
		else if(operand1.execute(symbolTable, programmData) instanceof Double && operand2.execute(symbolTable, programmData) instanceof Integer)
			return (double)operand1.execute(symbolTable, programmData) - Double.valueOf((int) operand2.execute(symbolTable, programmData));
		
		else
			return (int)operand1.execute(symbolTable, programmData) - (int)operand2.execute(symbolTable, programmData);
	}

}
