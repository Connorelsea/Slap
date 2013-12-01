package com.elsea.slap.client;

import javax.swing.JPanel;

/**
 *  <b>WindowPanel.class</b></br>
 *  <i>A class used to give extra functionality to JPanels, such as the ability to track
 *  progress for use in the Window Manager.</i></br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public abstract class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private boolean PROGRESS_STATE = false;
	private boolean TRACK_PROGRESS = false;
	
	private String NEXT_PANEL_NAME;
	
	public WindowPanel() {
		build();
	}
	
	public abstract void build();
	
	public boolean getTrackProgress() {
		return TRACK_PROGRESS;
	}
	
	public void setTrackProgress(boolean value) {
		TRACK_PROGRESS = value;
	}
	
	public void setDone(boolean value) {
		
		PROGRESS_STATE = value;
		
		if (PROGRESS_STATE == true) {
			Program.WINDOW_MANAGER.sendProgressFinish();
		}
		
	}
	
	public void setNextPanelName(String name) {
		NEXT_PANEL_NAME = name;
	}
	
	public String getNextPanelName() {
		return NEXT_PANEL_NAME;
	}

}