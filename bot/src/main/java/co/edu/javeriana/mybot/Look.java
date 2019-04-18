package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Look implements ASTNode {

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		try{
			programmData.getBot().look();
		} catch (Exception e) {
			System.err.println("Error en Look.");
			System.exit(0);
		}
		return null;
	}

}
