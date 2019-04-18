package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class VarRef implements ASTNode {
	
private String name;
	
	public VarRef(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		for(int i=symbolTable.size()-1;i>=0;i--){
			if (symbolTable.get(i).containsKey(this.name)){
				return symbolTable.get(i).get(name);
			}
		}
		System.err.println("La variable "+this.name+" no ha sido declarada.");
		System.exit(0);
		return null;
	}

}
