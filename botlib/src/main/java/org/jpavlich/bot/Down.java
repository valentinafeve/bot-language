package org.jpavlich.bot;

class Down extends Action<Integer> {
	
	private int steps;

	public Down(Bot bot, int steps) {
		super(bot);
		this.steps=steps;
	}

	@Override
	public Response<Integer> execute() {
		
		return new Response<Integer>(bot.down(steps));
	}

}
