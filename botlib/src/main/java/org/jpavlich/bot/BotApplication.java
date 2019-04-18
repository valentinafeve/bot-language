package org.jpavlich.bot;

import processing.core.PApplet;


public abstract class BotApplication implements Runnable {
	private BotApplet applet;
	
	public BotApplication(int waitTime) {
		applet = new BotApplet(this, waitTime);
	}

	@Override
	public void run() {
		try {
			execute(applet.getBotController());
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	
	public void start() {
		PApplet.runSketch(new String[] { BotApplet.class.getName() }, applet );
	}

	protected abstract void execute(Bot bot) throws Throwable;

}
