
package com.botlanguage.interpeter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jpavlich.bot.Bot;
import org.jpavlich.bot.BotApplication;

public class Main {

	private static final String EXTENSION = "bot";
	
	
	public static void main(String[] args) throws IOException {

		BotApplication app = new BotApplication(50) {

			@Override
			protected void execute(Bot bot) throws Throwable {
				String program = args.length > 1 ? args[1] : "test/testF." + EXTENSION;

				botLexer lexer = new botLexer(new ANTLRFileStream(program));

				System.out.println("Interpreting file " + program);

				CommonTokenStream tokens = new CommonTokenStream(lexer);
				botParser parser = new botParser(tokens, bot);

				botParser.ProgrammContext tree = parser.programm();

				botCustomVisitor visitor = new botCustomVisitor();
				visitor.visit(tree);

				System.out.println("\nInterpretation finished");
			}
		};
		app.start();

	}
	
	/*
	public static void main(String[] args) throws IOException {
		String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;

		System.out.println("Interpreting file " + program);

		botLexer lexer = new botLexer(new ANTLRFileStream(program));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		botParser parser = new botParser(tokens);

		parser.programm();
 
 		System.out.println("Interpretation finished");

	}
	*/
}