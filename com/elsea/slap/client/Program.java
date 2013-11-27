package com.elsea.slap.client;

public class Program {
	
	public static WindowManager WINDOW_MANAGER;
	
	private DisplayMainMenu DISPLAY_MAIN_MENU;
	
	public Program() {
		
		loadHelpers();
		initiateProgram();
		
	}
	
	public void initiateProgram() {
		
		DISPLAY_MAIN_MENU = new DisplayMainMenu();
		WINDOW_MANAGER.addPanel("MAIN_MENU", DISPLAY_MAIN_MENU);
		WINDOW_MANAGER.setBounds(850, 400);
		WINDOW_MANAGER.setCurrentPanel("MAIN_MENU");
		
	}
	
	public void loadHelpers() {
		
		WINDOW_MANAGER = new WindowManager();
		
	}

}