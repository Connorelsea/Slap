package com.elsea.slap.client;

import java.util.HashMap;

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
	
	private HashMap<String, WindowPanel> PANELS;
	private Window WINDOW;
	
	private String CURRENT_PANEL_NAME;
	private WindowPanel CURRENT_PANEL;
	private String TITLE;
	
	private String NEXT_PANEL_NAME;

	private boolean TRACK_PROGRESS;
	
	public WindowManager() {
		PANELS = new HashMap<String, WindowPanel>();
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
			
			if (CURRENT_PANEL != null) {
				
				if (CURRENT_PANEL.getTrackProgress() == true) {
					
					setTrackProgress(true);
					setNextPanel(CURRENT_PANEL.getNextPanelName());
					
				} else {
					setTrackProgress(false);
				}
				
				WINDOW.setCurrentPanel(CURRENT_PANEL);
			}
			
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
	public void addPanel(String identifier, WindowPanel panel) {
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
	
	/**
	 *  <b>trackProgress()</b></br>
	 *  <i>Makes the Window Manager check to see if the panel is "done."/i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param value To track progress or to not track progress.
	 */
	public void setTrackProgress(boolean value) {
		TRACK_PROGRESS = value;
	}
	
	public boolean isTrackingProgress() {
		return TRACK_PROGRESS;
	}
	
	/**
	 *  <b>setNextPanel()</b></br>
	 *  <i>Sets the panel that will become the current panel after the current panel
	 *  is "done."</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param identifier name of the panel to be added once progress is done.
	 */
	public void setNextPanel(String identifier) {
		
		if (PANELS.containsKey(identifier) == false) {
			System.out.println("[Warning] HashMap does not contain a panel with specified name.");
		}
		NEXT_PANEL_NAME = identifier;
	}
	
	/**
	 *  <b>setNextPanel()</b></br>
	 *  <i>Triggers to Window Manager to do actions that would be done upon
	 *  completion of a panel's actions. This method should be fired by the
	 *  current panel in order to alert the Window Manager that it is done.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void sendProgressFinish() {
		
		setCurrentPanel(NEXT_PANEL_NAME);

		NEXT_PANEL_NAME = "";
		setTrackProgress(false);
		
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