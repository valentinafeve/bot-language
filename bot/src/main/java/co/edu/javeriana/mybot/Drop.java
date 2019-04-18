package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Drop implements ASTNode {

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		try{
			programmData.getBot().drop();
		} catch (Exception e) {
			System.err.println("Error en Drop.");
			System.exit(0);
		}
		return null;
	}

}
