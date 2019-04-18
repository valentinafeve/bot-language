package org.jpavlich.bot;

public class Response<T> {
	private boolean isVoid;
	private T data;
	
	
	
	public Response() {
		this.isVoid = true;
		this.data = null;
	}
	public Response(T data) {
		super();
		this.data = data;
	}
	public boolean isVoid() {
		return isVoid;
	}
	public T getData() {
		return data;
	}
	
	
}
