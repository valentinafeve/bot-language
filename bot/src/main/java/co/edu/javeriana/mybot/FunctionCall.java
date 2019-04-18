package co.edu.javeriana.mybot;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FunctionCall implements ASTNode {

	private String functionName;
	private List<ASTNode> inputParameters;
	
	public FunctionCall(String functionName, List<ASTNode> inputParameters) {
		super();
		this.functionName = functionName;
		this.inputParameters = inputParameters;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgrammData programmData) {
		return programmData.executeFunction(this.functionName, this.inputParameters);
	}

}
