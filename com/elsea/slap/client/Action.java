package com.elsea.slap.client;

public abstract class Action {
	
	public abstract void definition();
	
	public void fire() {
		definition();
	}

}