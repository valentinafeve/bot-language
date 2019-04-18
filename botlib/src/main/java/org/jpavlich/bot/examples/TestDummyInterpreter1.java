package org.jpavlich.bot.examples;

import org.jpavlich.bot.Bot;
import org.jpavlich.bot.BotApplication;

public class TestDummyInterpreter1 {

	
	public static void main(String args[]) {

		BotApplication app = new BotApplication(50) {

			@Override
			protected void execute(Bot bot) throws Throwable {
				for (int j = 0; j < 8; j++) {
					for (int i = 0; i < 12; i++) {
						bot.right(1);
						printLook(bot);
					}
					bot.down(1);
					printLook(bot);
					for (int i = 0; i < 12; i++) {
						bot.left(1);
						printLook(bot);
					}
					bot.down(1);
					printLook(bot);
				}
			}

			private void printLook(Bot bot) {
				int look = bot.look();
				if (look > 0) {
					System.out.println(look);
				}
			}
		};
		
		app.start();
	}

	

}
