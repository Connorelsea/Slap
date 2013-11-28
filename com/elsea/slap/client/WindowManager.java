package com.elsea.slap.client;

import java.util.HashMap;

import javax.swing.JPanel;

/**
 *  <b>WindowManager.class</b></br>
 *  <i>A class used to manage a Window and the panels that will be used with it.
 *  No changes will be made to the Window itself until the refreshWindow() method
 *  is called.</i></br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public class WindowManager {
	
	private HashMap<String, JPanel> PANELS;
	private Window WINDOW;
	private String CURRENT_PANEL_NAME;
	private JPanel CURRENT_PANEL;
	
	private String TITLE;
	
	public WindowManager() {
		
		PANELS = new HashMap<String, JPanel>();
		createWindow();
		refreshWindow();
	}
	
	/**
	 *  <b>createWindow()</b></br>
	 *  <i>Creates the Window object that will be used </i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void createWindow() {
		WINDOW = new Window();
	}
	
	/**
	 *  <b>refreshWindow()</b></br>
	 *  <i>Updates window boundaries, sets the current panel, and turns
	 *  the Window visible. A general method used to update things pertaining
	 *  to the Window that the WindowManager cares for.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void refreshWindow() {
		
			WINDOW.updateBoundaries();
			if (CURRENT_PANEL != null) WINDOW.setCurrentPanel(CURRENT_PANEL);
			WINDOW.setTitle(TITLE);
			WINDOW.setVisible(true);
		
	}
	
	/**
	 *  <b>setCurrentPanel()</b></br>
	 *  <i>Sets the overall current panel object. Window must be refreshed
	 *  to actually change the panel that the Window displays.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param name string name of panel from the panel map to be set as the current panel.
	 */
	public void setCurrentPanel(String name) {
		
		if (PANELS.containsKey(name)) {
			CURRENT_PANEL = PANELS.get(name);
			CURRENT_PANEL_NAME = name;
		} else {
			System.out.println("[Error] Panel does not exist in the HashMap.");
		}
		
	}
	
	/**
	 *  <b>addPanel()</b></br>
	 *  <i>Adds a panel to the HashMap of panels.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param identifier Name that the panel will be called from now on.
 	 *  @param panel The JPanel to be added to the HashMap.
	 */
	public void addPanel(String identifier, JPanel panel) {
		PANELS.put(identifier, panel);
	}
	
	/**
	 *  <b>addPanel()</b></br>
	 *  <i>Removes a panel from the HashMap. Cannot remove a panel while it
	 *  is the current panel of the entire Window Manager.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param identifier name of the panel to be removed.
	 */
	public void removePanel(String identifier) {
		
		if (CURRENT_PANEL_NAME == identifier) {
			System.out.println("[Error] Cannot remove the panel currently being used.");
		} else {
			PANELS.remove(identifier);
		}
		
	}
	
	public void setBounds(int length, int width) {
		WINDOW.setBoundaries(length, width);
	}
	
	public void setTitle(String title) {
		TITLE = title;
	}
	
	public void removeAllPanels() {
		PANELS.clear();
	}
	
	public Window getWindow() {
		return WINDOW;
	}

}