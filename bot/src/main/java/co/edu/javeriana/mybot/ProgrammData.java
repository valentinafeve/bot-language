package co.edu.javeriana.mybot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.jpavlich.bot.Bot;

public class ProgrammData {
	private Map<String,Function> functions;
	private Stack<Map<String,Object>> symbolTables;
	private Bot bot;
	
	public ProgrammData(Bot bot) {
		super();
		this.functions = new HashMap<String, Function>();
		this.symbolTables = new Stack<Map<String,Object>>();
		this.symbolTables.add(new HashMap<String, Object>());
		this.bot = bot;
	}
	
	public void addFunction(Function function){
		this.functions.put(function.getFunctionName(), function);
	}

	public Object executeFunction(String FunctionName,List<ASTNode> inputParameters){
		return this.functions.get(FunctionName).executeFunction(inputParameters,this.symbolTables,this);
	}

	public Map<String, Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, Function> functions) {
		this.functions = functions;
	}
	
	public Stack<Map<String, Object>> getSymbolTables() {
		return symbolTables;
	}

	public void setSymbolTables(Stack<Map<String, Object>> symbolTables) {
		this.symbolTables = symbolTables;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}
}
