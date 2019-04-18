package org.jpavlich.bot;

class Drop extends Action<Boolean> {
	
	public Drop(Bot bot) {
		super(bot);
	}

	@Override
	public Response<Boolean> execute() {
		return new Response<Boolean>(bot.drop());
	}

}
