package com.elsea.slap.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.SwingUtilities;

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
	
	private Log LOG;
	
	private Dimension DIM_SCREEN;
	private int SCREEN_HEIGHT;
	private int SCREEN_WIDTH;
	private int BOUND_HEIGHT;
	private int BOUND_WIDTH;
	
	private String CURRENT_PANEL_NAME;
	private WindowPanel CURRENT_PANEL;
	private String TITLE;
	
	private String NEXT_PANEL_NAME;
	private boolean TRACK_PROGRESS;
	
	public WindowManager() {
		
		LOG = new Log();
		LOG.setSection("WindowManager");
		LOG.useSubSection(false);
		
		LOG.log("Measuring screen.");
		
		DIM_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
		SCREEN_HEIGHT = DIM_SCREEN.height;
		SCREEN_WIDTH = DIM_SCREEN.width;
		
		LOG.log("Creating HashMaps.");
		
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
		
		LOG.log("Creating Window.");
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
		
		LOG.setSubSection("Refresh");
			
		if (CURRENT_PANEL != null) {
			
			WINDOW.repaint();
			LOG.log("Current panel exists. Setting up information.");
				
			if (CURRENT_PANEL.getTrackProgress() == true) {
				
				LOG.log("Progress tracking turned on, setting next panel.");
				setTrackProgress(true);
				setNextPanel(CURRENT_PANEL.getNextPanelName());
				
			} else {
				LOG.log("Progress tracking turned off.");
				setTrackProgress(false);
			}
				
			LOG.log("Setting current panel.");
			WINDOW.setCurrentPanel(CURRENT_PANEL);
			
			if (BOUND_HEIGHT != WINDOW.getBoundLength() ||
				BOUND_WIDTH != WINDOW.getBoundWidth())
			{
				LOG.log("Forcing window visiblity to false to update boundaries.");
				WINDOW.setVisible(false);
				LOG.log("Updating boundaries.");
				WINDOW.setBoundaries(BOUND_HEIGHT, BOUND_WIDTH);	

				try {	
					SwingUtilities.invokeAndWait(new Runnable() {
						@Override
						public void run() {
							WINDOW.updateBoundaries();
						}	
					});
				} catch (Exception ex) { ex.printStackTrace(); }
			}
					
			LOG.log("Applying window attributes.");
			WINDOW.setTitle(TITLE);
			LOG.log("Forcing window visibility to true.");
			WINDOW.setVisible(true);
					
			LOG.log("Forcing window to move to centered position.");
			WINDOW.setLocationRelativeTo(null);
			LOG.log("Repainting window.");
			WINDOW.repaint();
				
		} else {
			LOG.log("No current panel, window cannot be refreshed.");
		}
		
		LOG.useSubSection(false);
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
			
			LOG.log("Setting current panel to \"" + name + "\".");
			CURRENT_PANEL = PANELS.get(name);
			CURRENT_PANEL_NAME = name;
			
		} else {
			
			LOG.setSubSection("Error");
			LOG.log("Attempted current panel does not exist in the HashMap.");
			LOG.useSubSection(false);
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
		
		LOG.log("Adding panel named \"" + identifier + "\" to the HashMap.");
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
			
			LOG.setSubSection("Error");
			LOG.log("Denied the attempt to remove a panel that is currently in use.");
			LOG.useSubSection(false);
			
		} else {
			
			LOG.log("Removing panel \"" + identifier + "\"");
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
			
			LOG.setSubSection("Warning");
			LOG.log("HashMap does not contain a panel with specified name." +
					" Allowing addition. anyways.");
			LOG.useSubSection(false);
		
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
		
		LOG.log("Progress finished signal recieved.");
		setCurrentPanel(NEXT_PANEL_NAME);
		NEXT_PANEL_NAME = "";
		setTrackProgress(false);
		
	}
	
	public boolean isProgresFinished() {
		if (TRACK_PROGRESS == true) return false; else return true;
	}
	
	
	public void setIcon() {
		//planned
	}
	
	public void setBounds(int length, int width) {
		BOUND_HEIGHT = length;
		BOUND_WIDTH = width;
	}
	
	public void setTitle(String title) {
		TITLE = title;
	}
	
	public String getTitle() {
		return TITLE;
	}
	
	public void removeAllPanels() {
		PANELS.clear();
	}
	
	public Window getWindow() {
		return WINDOW;
	}
	
	public int getScreenWidth() {
		return SCREEN_WIDTH;
	}
	
	public int getScreenHeight() {
		return SCREEN_HEIGHT;
	}

}