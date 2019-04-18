package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Pick implements ASTNode {
	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		try{
			programmData.getBot().pick();
		} catch (Exception e) {
			 System.err.println("-> ERROR en South la expresion no es posible castear a entero");
			 System.exit(0);
		}
		return null;
	}

}
