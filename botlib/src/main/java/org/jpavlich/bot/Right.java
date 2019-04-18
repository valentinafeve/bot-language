package org.jpavlich.bot;

class Right extends Action<Integer> {
	
	private int angle;

	public Right(Bot bot, int angle) {
		super(bot);
		this.angle=angle;
	}

	@Override
	public Response<Integer> execute() {
		
		return new Response<Integer>(bot.right(angle));
	}

}
