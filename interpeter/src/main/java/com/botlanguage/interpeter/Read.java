package com.botlanguage.interpeter;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class Read implements ASTNode {
	private String name;

	public Read(String name) {
		this.name = name;
	}

	@Override
	public Object execute(List<Map<String,Object>> symbolTable, Bot bot, Map<String, Function> functionTable) {

		for(int i=1;i<=symbolTable.size();i++) {
			if(symbolTable.get(symbolTable.size()-i).containsKey(name)) {


				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String s;
				try {
					s = in.readLine();

					if(s.equals("true") || s.equals("false")) {
						boolean data = Boolean.parseBoolean(s);
						symbolTable.get(symbolTable.size()-i).put(name,data);
						return null;
					}
					try{
						int data = Integer.parseInt(s);
						symbolTable.get(symbolTable.size()-i).put(name,data);
						return null;
					}catch (Exception e) {}
					try{
						double data = Double.parseDouble(s);
						symbolTable.get(symbolTable.size()-i).put(name,data);
						return null;
					}catch (Exception e) {}

					symbolTable.get(symbolTable.size()-i).put(name,s);
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				break;
			}
		}
		return null;
	}

}
