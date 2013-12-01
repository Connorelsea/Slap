package com.elsea.slap.client;

public class Program {
	
	public static WindowManager WINDOW_MANAGER;
	public static ResourceManager RESOURCE_MANAGER;
	public static FontManager FONT_MANAGER;
	
	public static DisplayMainMenu DISPLAY_MAIN_MENU;
	public static DisplayLoading DISPLAY_LOADING;
	
	public Program() {
		
		System.out.println(
				"\n" +
				"Elsea Labs 2013-2014\n" + 
				"BSD 3-Clause License, Open Source\n" +
				
				"\nWork until your idols are your rivals\n\n"
			);
		
		loadHelpers();
		initiateProgram();
		
	}
	
	public void initiateProgram() {
		
		DISPLAY_LOADING = new DisplayLoading();
		DISPLAY_LOADING.setNextPanelName("MAIN_MENU");
		
		WINDOW_MANAGER.addPanel("LOADING", DISPLAY_LOADING);
		WINDOW_MANAGER.setBounds(600, 600);
		WINDOW_MANAGER.setCurrentPanel("LOADING");
		WINDOW_MANAGER.refreshWindow();
		
	}
	
	public void loadHelpers() {
		
		WINDOW_MANAGER = new WindowManager();
		RESOURCE_MANAGER = new ResourceManager();
		FONT_MANAGER = new FontManager();
		
	}

}