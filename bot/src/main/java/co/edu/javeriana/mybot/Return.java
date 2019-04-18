package co.edu.javeriana.mybot;

import java.util.Map;
import java.util.Stack;

public class Return implements ASTNode {

	private ASTNode expression;
	private Object returning;
	
	public Return(ASTNode expression) {
		super();
		this.expression = expression;
		this.returning=null;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgrammData programmData) {
		this.returning=this.expression.execute(symbolTables, programmData);
		return this;
	}

	public Object getReturn_() {
		return returning;
	}

	public void setReturn_(Object returning) {
		this.returning = returning;
	}

}
