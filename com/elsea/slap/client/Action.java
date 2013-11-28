package com.elsea.slap.client;

/**
 *  <b>Action.class</b></br>
 *  <i>A small class to replicate the functionality of ActionListener related
 *  classes in a more stylistic and simplistic fashion.</i></br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public abstract class Action {
	
	public abstract void definition();
	
	public void fire() {
		definition();
	}

}