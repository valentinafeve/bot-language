package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Pow implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	public Pow(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		for(int i=0;i<10;i++) {
			
		}
	}
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		if(operand1.execute(symbolTable, programmData) instanceof Integer && operand2.execute(symbolTable, programmData) instanceof Integer)
			return (int) Math.pow((int)operand1.execute(symbolTable, programmData), (int)operand2.execute(symbolTable, programmData));
		
		else if(operand1.execute(symbolTable, programmData) instanceof Integer && operand2.execute(symbolTable, programmData) instanceof Double)
			return (int) Math.pow((int) operand1.execute(symbolTable, programmData), (double)operand2.execute(symbolTable, programmData));
		
		else if(operand1.execute(symbolTable, programmData) instanceof Double && operand2.execute(symbolTable, programmData) instanceof Integer)
			return (int) Math.pow((double)operand1.execute(symbolTable, programmData), (int) operand2.execute(symbolTable, programmData));

		else
			return Math.pow((double)operand1.execute(symbolTable, programmData), (double)operand2.execute(symbolTable, programmData));
		
	}

}
