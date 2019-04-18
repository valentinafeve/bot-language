package org.jpavlich.bot.examples;

import org.jpavlich.bot.Bot;
import org.jpavlich.bot.BotApplication;

public class TestDummyInterpreter1 {

	
	public static void main(String args[]) {

		BotApplication app = new BotApplication(50) {

			@Override
			protected void execute(Bot bot) throws Throwable {
				for (int j = 0; j < 1; j++) {
					for (int i = 0; i < 1; i++) {
						bot.right(1);
					}
					bot.down(1);
					for (int i = 0; i < 1; i++) {
						bot.left(1);
					}
					bot.down(1);
				}
			}

		};
		
		app.start();
	}

	

}
