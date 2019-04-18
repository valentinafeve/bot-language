package org.jpavlich.bot;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Scheduler {
	private BlockingQueue<Action<?>> actions = new ArrayBlockingQueue<Action<?>>(1);
	private BlockingQueue<Response<?>> responses = new ArrayBlockingQueue<Response<?>>(1);


	@SuppressWarnings("unchecked")
	public <T> T schedule(Action<T> action) {
		try {
			actions.put(action);
			return (T) responses.take().getData();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void executeNext() {
		Action<?> nextAction;
		try {
			nextAction = actions.take();
			responses.put(nextAction.execute());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
