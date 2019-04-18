package org.jpavlich.bot;

public class Inventory extends Action<Integer> {

	public Inventory(Bot bot) {
		super(bot);
	}

	@Override
	public Response<Integer> execute() {
		return new Response<Integer>(bot.inventory());
	}

}
