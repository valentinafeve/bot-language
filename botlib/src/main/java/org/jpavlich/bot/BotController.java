package org.jpavlich.bot;

class BotController implements Bot {
	private Scheduler scheduler = new Scheduler();

	private BotModel bot;

	public BotController(BotModel bot, Scheduler scheduler) {
		this.bot = bot;
		this.scheduler = scheduler;
	}

	@Override
	public int down(int steps) {
		int stepsMoved = 0;
		for (int i = 0; i < steps; i++) {
			int step = scheduler.schedule(new Down(bot, 1));
			if (step == 0) {
				return stepsMoved;
			}
			stepsMoved += step;
		}
		return stepsMoved;

	}

	@Override
	public int up(int steps) {
		int stepsMoved = 0;
		for (int i = 0; i < steps; i++) {
			int step = scheduler.schedule(new Up(bot, 1));
			if (step == 0) {
				return stepsMoved;
			}
			stepsMoved += step;
		}
		return stepsMoved;
	}

	@Override
	public int left(int steps) {
		int stepsMoved = 0;
		for (int i = 0; i < steps; i++) {
			int step = scheduler.schedule(new Left(bot, 1));
			if (step == 0) {
				return stepsMoved;
			}
			stepsMoved += step;
		}
		return stepsMoved;
	}

	@Override
	public int right(int steps) {
		int stepsMoved = 0;
		for (int i = 0; i < steps; i++) {
			int step = scheduler.schedule(new Right(bot, 1));
			if (step == 0) {
				return stepsMoved;
			}
			stepsMoved += step;
		}
		return stepsMoved;

	}

	@Override
	public boolean drop() {
		return scheduler.schedule(new Drop(bot));
	}

	@Override
	public boolean pick() {
		return scheduler.schedule(new Pick(bot));

	}

	@Override
	public int look() {
		return scheduler.schedule(new Look(bot));
	}

	@Override
	public int inventory() {
		return scheduler.schedule(new Inventory(bot));
	}
	


}
