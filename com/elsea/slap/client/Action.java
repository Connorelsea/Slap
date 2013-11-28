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
	
	/**
	 *  <b>definition()</b></br>
	 *  <i>An abstracted method where the user will define various actions.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public abstract void definition();
	
	/**
	 *  <b>fire()</b></br>
	 *  <i>Included for style and readability. This fires the definition method,
	 *  and in turn "fires" the action that is being held by this object.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void fire() {
		definition();
	}

}