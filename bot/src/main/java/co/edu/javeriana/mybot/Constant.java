package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Constant implements ASTNode {
	
	private Object value;
	
	public Constant(Object value) {
		super();
		this.value = value;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programInfo){
		return value;
	}

}
