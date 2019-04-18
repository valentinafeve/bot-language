package org.jpavlich.bot;

class Up extends Action<Integer> {
	
	private int steps;

	public Up(Bot bot, int steps) {
		super(bot);
		this.steps=steps;
	}

	@Override
	public Response<Integer> execute() {
		
		return new Response<Integer>(bot.up(steps));
	}

}
