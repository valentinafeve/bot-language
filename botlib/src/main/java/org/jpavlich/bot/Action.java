package org.jpavlich.bot;

public abstract class Action<R> {
	protected Bot bot;
	public Action(Bot bot) {
		this.bot = bot;
	}
	public abstract Response<R> execute();
	
}
