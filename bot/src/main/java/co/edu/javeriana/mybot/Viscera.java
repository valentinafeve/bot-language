package co.edu.javeriana.mybot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Viscera implements ASTNode {
	private List<ASTNode>  body;
	
	public Viscera() {
		super();
		this.body= new ArrayList<ASTNode>();
	}

	public Viscera(List<ASTNode> body) {
		super();
		this.body = body;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgrammData programmData) {
		Object return_=null;
			if(this.body!=null){
				symbolTables.push(new HashMap<String, Object>());
				for(ASTNode n: this.body){
					return_=n.execute(symbolTables, programmData);
					if(return_!=null && return_ instanceof Return){
						symbolTables.pop();
						return return_;
					}
				}
				symbolTables.pop();
			}
		return null;
	}
	
	public List<ASTNode> getBody() {
		return body;
	}

	public void setBody(List<ASTNode> body) {
		this.body = body;
	}

	public void add(ASTNode node){
		this.body.add(node);
	}

}
