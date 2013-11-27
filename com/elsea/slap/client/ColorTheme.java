package com.elsea.slap.client;

import java.awt.Color;
import java.util.HashMap;

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