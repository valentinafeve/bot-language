package com.botlanguage.interpeter;

import java.util.Map;
import java.util.Scanner;

import org.jpavlich.bot.Bot;

public class Read implements ASTNode {
	private String name;
	
	public Read(String name) {
		this.name = name;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		if(s.equals("true") || s.equals("false")) {
				boolean data = Boolean.parseBoolean(s);
				symbolTable.put(name,data);
				return null;
		}
		try{
			int data = Integer.parseInt(s);
			symbolTable.put(name,data);
			return null;
		}catch (Exception e) {}
		try{
			double data = Double.parseDouble(s);
			symbolTable.put(name,data);
			return null;
		}catch (Exception e) {}
		
		symbolTable.put(name,s);
		in.close();
		return null;
	}

}
