package org.jpavlich.bot.examples;

import org.jpavlich.bot.Bot;
import org.jpavlich.bot.BotApplication;

public class TestDummyInterpreter2 {

	/**
	 * Este metodo muestra la forma de ejecutar la aplicacion. El primer
	 * parametro corresponde al intérprete que procesará el programa fuente que
	 * se pasa como segundo parametro.
	 * 
	 * Para crear un intérprete propio, basta con crear una subclase de
	 * {@link Interpreter} e implementar el metodo
	 * {@link Interpreter#executeProgram(String, org.jpavlich.bot.Bot)} el cual
	 * debería ser capaz de procesar el archivo programa.bot
	 */
	public static void main(String args[]) {

		BotApplication app = new BotApplication(50) {
			private int objectsInRow;
			private boolean thereAreObjectsNotMoved;

			@Override
			protected void execute(Bot bot) throws Throwable {
				while (true) {
					moveObjsToRight(bot);
					if (bot.down(1) < 1) {
						return;
					}
				}

			}

			private void moveObjsToRight(Bot bot) {
				thereAreObjectsNotMoved = true;
				countObjectsInRow(bot);
				while (thereAreObjectsNotMoved) {

					if (findObjectToPick(bot)) {
						System.out.println("Picked object");
						if (findPositionToDrop(bot)) {
							System.out.println("Found position to drop");
						} else {
							System.out.println("Could not drop object");
						}
					} else {
						thereAreObjectsNotMoved = false;
					}
				}

			}

			private void countObjectsInRow(Bot bot) {
				System.out.println("Counting objects in this row");
				objectsInRow = 0;
				// Counts objects to the right
				while (bot.right(1) == 1) {
					if (bot.look() != 0) {
						objectsInRow++;
					}
				}

			}

			private boolean findObjectToPick(Bot bot) {
				System.out.println("Finding object to pick");
				int steps = 0;
				// Goes back to the left until the zone where there are objects
				// to
				// pick
				// (0 <= x <= (width - objectsInRow))
				while (steps < objectsInRow && bot.left(1) == 1) {
					steps++;
				}
				while (bot.look() == 0 && bot.left(1) == 1) {
				}

				return bot.pick();
			}

			private boolean findPositionToDrop(Bot bot) {
				System.out.println("Finding pos to drop");

				while (bot.right(1) == 1) {

				}
				while (bot.look() != 0 && bot.left(1) == 1) {

				}
				return bot.drop();
			}

		};
		app.start();
	}

}
