package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Division implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	public Division(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programInfo) {
		if(operand1.execute(symbolTable, programInfo) instanceof Double && operand2.execute(symbolTable, programInfo) instanceof Double)
			return (double)operand1.execute(symbolTable, programInfo) / (double)operand2.execute(symbolTable, programInfo);
		
		else if(operand1.execute(symbolTable, programInfo) instanceof Integer && operand2.execute(symbolTable, programInfo) instanceof Double)
			return Double.valueOf((int) operand1.execute(symbolTable, programInfo)) / (double)operand2.execute(symbolTable, programInfo);
		
		else if(operand1.execute(symbolTable, programInfo) instanceof Double && operand2.execute(symbolTable, programInfo) instanceof Integer)
			return (double)operand1.execute(symbolTable, programInfo) / Double.valueOf((int) operand2.execute(symbolTable, programInfo));
		
		else if (operand1.execute(symbolTable, programInfo) instanceof Integer && operand2.execute(symbolTable, programInfo) instanceof Integer)
			return (int)operand1.execute(symbolTable, programInfo) / (int)operand2.execute(symbolTable, programInfo);
		
		else
			return operand1.execute(symbolTable, programInfo).toString() + operand2.execute(symbolTable, programInfo).toString();
	}

}
