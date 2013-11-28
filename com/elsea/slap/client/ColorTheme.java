package com.elsea.slap.client;

import java.awt.Color;
import java.util.HashMap;

/**
 *  <b>ColorTheme.class</b></br>
 *  <i>A small class to hold sets of colors.</i></br>
 *  </br>
 *  A small class to hold sets of colors. The intention is to
 *  make certain sets of colors transfer easy around a program
 *  in a single object. </br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public class ColorTheme {
	
	private HashMap<String, Color> COLORS = new HashMap<String, Color>();
	
	public ColorTheme() {
		COLORS = new HashMap<String, Color>();
	}
	
	public void addColor(String name, Color color) {
		if (COLORS.size() == 0) COLORS.put("fallback", color);
		COLORS.put(name, color);
	}
	
	public Color getColor(String name) {
		if (COLORS.get(name) == null) return COLORS.get("fallback");
		else return COLORS.get(name);
	}

}