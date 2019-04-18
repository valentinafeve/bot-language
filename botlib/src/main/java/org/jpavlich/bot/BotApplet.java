package org.jpavlich.bot;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Representa la ventana donde se ejecutará el programa del robot. Para ejecutar
 * la aplicación hay que agregar en el método main una llamada a {@link #run()}
 * de la siguiente forma:
 * 
 * <pre>
 * public static void main(String args[]) {
 * 	botApplication.run(new MyInterpreter(), new File(&quot;programa.bot&quot;));
 * }
 * </pre>
 * 
 * Donde MyInterpreter corresponde a la instancia de la subclase Interpreter que
 * se quiere utilizar para ejecutar la aplicación de el robot. El segundo
 * argumento corresponde al archivo de texto con el programa que ejecutará el
 * robot
 * 
 * @author jaime.pavlich-mariscal
 * 
 */
public class BotApplet extends PApplet {
	private BotModel botModel;
	private BotController bot;
	private LayerManager layers;

	private Scheduler scheduler;
	private long waitTime;
	private WorldView worldView;
	private WorldModel worldModel;
	private Runnable interpreter;

	public BotApplet(Runnable interpreter, long waitTime) {
		this.interpreter = interpreter;
		this.waitTime = waitTime;
	}

	@Override
	public void settings() {
		size(800, 600);
	}

	public void setup() {
		background(0);
		layers = new LayerManager();
		scheduler = new Scheduler();
		PImage botSprite = loadImage("./images/bot.png");
		worldModel = createWorld(botSprite);

		initBot(worldModel, botSprite);

		new Thread(interpreter).start();
	}

	private WorldModel createWorld(PImage botSprite) {
		WorldModel wm = new WorldModel(width / BotView.STEP_SIZE, height / BotView.STEP_SIZE);
		worldView = new WorldView(this, wm, botSprite);
		layers.addLayer(worldView);
		return wm;
	}

	private void initBot(WorldModel worldModel, PImage botSprite) {
		botModel = new BotModel(worldModel);
		BotView botView = new BotView(this, botModel, botSprite);
		layers.addLayer(botView);

		bot = new BotController(botModel, scheduler);
		// botModel.setPos(getWidth() / (2*BotView.STEP_SIZE), getHeight() /
		// (2*BotView.STEP_SIZE));
		botModel.setPos(0, 0);
	}

	@Override
	public void draw() {
		scheduler.executeNext();
		layers.draw();
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

	public BotController getBotController() {
		return bot;
	}

	

	@Override
	public void stop() {
		super.stop();
		System.exit(0);
	}

}