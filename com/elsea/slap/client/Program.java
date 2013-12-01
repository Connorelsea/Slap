package com.elsea.slap.client;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Program {
	
	public static WindowManager WINDOW_MANAGER;
	public static ResourceManager RESOURCE_MANAGER;
	public static FontManager FONT_MANAGER;
	
	public static DisplayMainMenu DISPLAY_MAIN_MENU;
	public static DisplayLoading DISPLAY_LOADING;
	public static DisplayMultiplayer DISPLAY_MULTIPLAYER;
	
	
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
		
		try {
			
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					DISPLAY_LOADING.loadItems();
				}
				
			});
			
		} catch (InvocationTargetException | InterruptedException e) {
			
			e.printStackTrace();
			
		} finally {
			
			Program.WINDOW_MANAGER.sendProgressFinish();
			Program.WINDOW_MANAGER.setBounds(1000, 650);
			Program.WINDOW_MANAGER.setTitle("Elsea : Slap");
			Program.WINDOW_MANAGER.refreshWindow();
			
		}
		
	}
	
	public void loadHelpers() {
		
		WINDOW_MANAGER = new WindowManager();
		RESOURCE_MANAGER = new ResourceManager();
		FONT_MANAGER = new FontManager();
		
	}

}