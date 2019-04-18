package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public interface ASTNode {
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgrammData programmData);
}
