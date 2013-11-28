package com.elsea.slap.client;

public class Program {
	
	public static WindowManager WINDOW_MANAGER;
	public static ResourceManager RESOURCE_MANAGER;
	
	private DisplayMainMenu DISPLAY_MAIN_MENU;
	private DisplayLoading DISPLAY_LOADING;
	
	public Program() {
		
		loadHelpers();
		loadResources();
		
		initiateProgram();
		
	}
	
	public void initiateProgram() {
		
		DISPLAY_MAIN_MENU = new DisplayMainMenu();
		DISPLAY_LOADING = new DisplayLoading();
		
		WINDOW_MANAGER.addPanel("LOADING", DISPLAY_LOADING);
		WINDOW_MANAGER.setBounds(600, 600);
		WINDOW_MANAGER.setCurrentPanel("LOADING");
		
		//WINDOW_MANAGER.addPanel("MAIN_MENU", DISPLAY_MAIN_MENU);
		//WINDOW_MANAGER.setBounds(850, 400);
		//WINDOW_MANAGER.setCurrentPanel("MAIN_MENU");
		
	}
	
	public void loadHelpers() {
		
		WINDOW_MANAGER = new WindowManager();
		RESOURCE_MANAGER = new ResourceManager();
		
	}
	
	public void loadResources() {
		
		RESOURCE_MANAGER.addImage("BACKGROUND_WOOD", "res/images/WOOD.jpg");
		
	}

}