package org.jpavlich.bot;

import processing.core.PApplet;
import processing.core.PImage;

class BotView extends Layer {

	public static final int STEP_SIZE = 60;
	public static final int OFFSET = STEP_SIZE / 2;
	PImage botSprite;
	private BotModel bot;

	public BotView(PApplet parent, BotModel bot, PImage sprite) {
		super(parent);
		botSprite = sprite;
		this.bot = bot;
	}

	@Override
	public void init() {
	}

	@Override
	public void draw() {
		float x = bot.getX() * STEP_SIZE + OFFSET;
		float y = bot.getY() * STEP_SIZE + OFFSET;
		translate(x, y);
		image(botSprite, -botSprite.width / 2, -botSprite.height / 2);
	}

}
