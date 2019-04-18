package org.jpavlich.bot;

class Left extends Action<Integer> {
	
	private int angle;

	public Left(Bot bot, int angle) {
		super(bot);
		this.angle=angle;
	}

	@Override
	public Response<Integer> execute() {
		
		return new Response<Integer>(bot.left(angle));
	}

}
