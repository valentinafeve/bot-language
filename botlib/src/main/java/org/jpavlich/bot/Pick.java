package org.jpavlich.bot;

class Pick extends Action<Boolean> {
	
	public Pick(Bot bot) {
		super(bot);
	}

	@Override
	public Response<Boolean> execute() {
		
		return new Response<Boolean>(bot.pick());
	}

}
