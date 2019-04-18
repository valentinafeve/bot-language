package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Look implements ASTNode {

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData){
		try{
			programmData.getBot().look();
		} catch (Exception e) {
			 System.err.println("-> ERROR en South la expresion no es posible castear a entero");
			 System.exit(0);
		}
		return null;
	}

}
