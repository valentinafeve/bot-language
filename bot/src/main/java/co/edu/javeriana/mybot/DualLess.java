package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class DualLess implements ASTNode {
	private String name;
	
	public DualLess(String operand) {
		super();
		this.name = operand;
	}

	
	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgrammData programmData) {
		for(int i=symbolTables.size()-1;i>=0;i--){
			if (symbolTables.get(i).containsKey(this.name)){
				Object data = symbolTables.get(i).containsKey(this.name);
				data = (int) data-1;
				return null;
			}
		}
		return null;
	}
}
