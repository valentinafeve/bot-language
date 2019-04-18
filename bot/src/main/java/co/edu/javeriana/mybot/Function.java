package co.edu.javeriana.mybot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Function implements ASTNode{

	private String name;
	private List<String> inputParameters;
	private Viscera viscera;
	
	public Function(String functionName, List<String> inputParameters,
			Viscera viscera) {
		super();
		this.name = functionName;
		this.inputParameters = inputParameters;
		this.viscera = viscera;
	}
	
	public Object execute(String name, Stack<Map<String, Object>>  symbolTables, ProgrammData programmData) {
		programmData.addFunction(this);
		return null;
	}

	public Object executeFunction(List<ASTNode> parameters,Stack<Map<String,Object>>  symbolTables,ProgrammData programmData){
		Map<String,Object> symbolTable = new HashMap<String, Object>();
		for (int i=0;i<inputParameters.size();i++){
			symbolTable.put(this.inputParameters.get(i), parameters.get(i).execute(symbolTables, programmData));
		}
		symbolTables.push(symbolTable);
		Object return_=this.viscera.execute(symbolTables, programmData);
		symbolTables.pop();
		if(return_ !=null && return_  instanceof Return){
			return ((Return) return_ ).getReturn_();
		}
		return null;
	}

	public String getFunctionName() {
		return name;
	}

	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgrammData programInfo) {
		programInfo.addFunction(this);
		return null;
	}
}
