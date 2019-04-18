package org.jpavlich.bot;

class BotModel implements Bot {
	private int x = 0;
	private int y = 0;

	private int prevX;
	private int prevY;
	private WorldModel worldModel;

	/**
	 * El elemento que carga el robot
	 */
	private int elem;

	public BotModel(WorldModel worldModel) {
		this.worldModel = worldModel;
	}

	public synchronized int getX() {
		return x;
	}

	public synchronized int getY() {
		return y;
	}

	synchronized int getPrevX() {
		return prevX;
	}

	synchronized int getPrevY() {
		return prevY;
	}

	@Override
	public int right(int steps) {
		return move(steps, 0);
	}

	@Override
	public int left(int steps) {
		return move(-steps, 0);
	}

	@Override
	public int up(int steps) {
		return move(0, -steps);
	}

	@Override
	public int down(int steps) {
		return move(0, steps);
	}

	synchronized void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	synchronized int move(int dx, int dy) {
		prevX = x;
		prevY = y;
		x += dx;
		y += dy;
		if (x < 0) {
			x = 0;
		}
		if (x >= worldModel.getWidth()) {
			x = worldModel.getWidth() - 1;
		}

		if (y < 0) {
			y = 0;
		}
		if (y >= worldModel.getHeight()) {
			y = worldModel.getHeight() - 1;
		}
		
		return Math.max(Math.abs(x-prevX), Math.abs(y-prevY));

	}

	@Override
	public synchronized boolean drop() {
		if (worldModel.drop(x, y, elem)) {
			elem = 0;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public synchronized boolean pick() {
		if (elem == 0) {
			elem = worldModel.pick(x, y);
			if (elem != 0) {
				return true;
			}
		}
		return false;

	}

	@Override
	public int look() {
		return worldModel.get(x, y);
	}

	@Override
	public int inventory() {
		return elem;
	}

}
