package co.edu.javeriana.mybot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Read implements ASTNode {
	private String name;
	
	public Read(String name) {
		this.name = name;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTable, ProgrammData programmData) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s=br.readLine();
			boolean f=false;
			for(int i=symbolTable.size()-1;i>=0;i--){
				if (symbolTable.get(i).containsKey(this.name)){
					try {
						symbolTable.get(i).put(this.name,Double.parseDouble(s));
					} catch (Exception e) {
						symbolTable.get(i).put(this.name,s);
					}
					f=true;
				}
			}
			if(!f){
				 System.err.println("La variable "+this.name+" no existe.");
				 System.exit(0);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
