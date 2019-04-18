package org.jpavlich.bot;

class Look extends Action<Integer> {
	
	public Look(Bot bot) {
		super(bot);
	}

	@Override
	public Response<Integer> execute() {
		return new Response<Integer>(bot.look());
	}

}
