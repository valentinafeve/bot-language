package org.jpavlich.bot;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

import processing.core.PApplet;
import processing.core.PImage;

class WorldView extends Layer {

	private PImage[] sprites;
	private WorldModel worldModel;

	public WorldView(PApplet parent, WorldModel worldModel, PImage defaultSprite) {
		super(parent);
		this.worldModel = worldModel;
		loadSprites(parent, defaultSprite);
	}

	private void loadSprites(PApplet parent, PImage defaultSprite) {
		File imageDir = new File("images");
		File[] spriteFiles = imageDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().matches("[0-9]+\\.png");
			}
		});
		Arrays.sort(spriteFiles);
		sprites = new PImage[spriteFiles.length + 1];
		sprites[0] = defaultSprite;
		for (int i = 0; i < spriteFiles.length; i++) {
			try {
				sprites[i + 1] = parent.loadImage(spriteFiles[i].getCanonicalPath());
				System.err.println("Loading sprite " + i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void init() {
		draw();
	}

	@Override
	public void draw() {
		background(0, 0);
		int w = worldModel.getWidth() * BotView.STEP_SIZE;
		int h = worldModel.getHeight()* BotView.STEP_SIZE;
		for (int x = 0; x < w; x += BotView.STEP_SIZE) {
			stroke(128, 128, 128, 255);
			line(x, 0, x, getHeight());
			for (int y = 0; y < h; y += BotView.STEP_SIZE) {
				stroke(128, 128, 128, 255);
				line(0, y, getWidth(), y);
				int elem = worldModel.get(x / BotView.STEP_SIZE, y / BotView.STEP_SIZE);
				if (elem == 0) {
					stroke(0, 0, 0, 255);
					fill(0, 0, 0, 255);
					rect(x + 1, y + 1, BotView.STEP_SIZE - 2, BotView.STEP_SIZE - 2);
				} else {
					if (elem < sprites.length) {
						image(sprites[elem], x, y);
						stroke(255, 255, 255, 255);
						fill(255, 255, 255, 255);
						text(elem, x+5, y+15);
					} else {
						image(sprites[0], x, y);
						stroke(128, 128, 128, 255);
						text(elem, x+5, y+15);
					}
				}
			}
		}
	}

}
