package com.elsea.slap.client;

import java.util.HashMap;

import javax.swing.JPanel;

/**
 *  <b>WindowManager.class</b></br>
 *  <i>A class used to manage a Window and the panels that will be used with it.</i></br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public class WindowManager {
	
	private HashMap<String, JPanel> PANELS;
	private Window WINDOW;
	private JPanel CURRENT_PANEL;
	
	public WindowManager() {
		
		PANELS = new HashMap<String, JPanel>();
		refreshWindow();
	}
	
	public void setBounds(int length, int width) {
		WINDOW.setBoundaries(length, width);
		WINDOW.updateBoundaries();
	}
	
	public void refreshWindow() {
		
		if (WINDOW == null) {
			WINDOW = new Window();
			return;
		}
		
		WINDOW.updateBoundaries();
		if (CURRENT_PANEL != null) WINDOW.setCurrentPanel(CURRENT_PANEL);
		WINDOW.setVisible(true);
		
	}
	
	public void setCurrentPanel(String name) {
		
		CURRENT_PANEL = PANELS.get(name);
		WINDOW.setCurrentPanel(CURRENT_PANEL);
		refreshWindow();
		
	}
	
	public void addPanel(String identifier, JPanel panel) {
		PANELS.put(identifier, panel);
	}
	
	public void removePanel(String identifier) {
		PANELS.remove(identifier);
	}
	
	public Window getWindow() {
		return WINDOW;
	}

}