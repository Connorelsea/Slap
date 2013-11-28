package com.elsea.slap.client;

public class Program {
	
	public static WindowManager WINDOW_MANAGER;
	public static ResourceManager RESOURCE_MANAGER;
	
	public static DisplayMainMenu DISPLAY_MAIN_MENU;
	public static DisplayLoading DISPLAY_LOADING;
	
	public Program() {
		
		loadHelpers();
		initiateProgram();
		
	}
	
	public void initiateProgram() {
		
		System.out.println("HERE 2");
		
		
		DISPLAY_LOADING = new DisplayLoading();
		DISPLAY_LOADING.setNextPanelName("MAIN_MENU");
		
		System.out.println("HERE 3");
		
		WINDOW_MANAGER.addPanel("LOADING", DISPLAY_LOADING);
		WINDOW_MANAGER.setBounds(600, 600);
		WINDOW_MANAGER.setCurrentPanel("LOADING");
		WINDOW_MANAGER.refreshWindow();
		
	}
	
	public void loadHelpers() {
		
		System.out.println("HERE");
		
		WINDOW_MANAGER = new WindowManager();
		RESOURCE_MANAGER = new ResourceManager();
		
	}

}