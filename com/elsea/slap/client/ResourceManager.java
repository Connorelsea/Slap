package com.elsea.slap.client;

import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ResourceManager {
	
	private HashMap<String, String> IMAGE_URLS;
	private HashMap<String, ImageIcon> IMAGES;
	private ClassLoader CL;
	private URL CURRENT_URL;
	
	public ResourceManager() {
		IMAGE_URLS = new HashMap<String, String>();
		IMAGES = new HashMap<String, ImageIcon>();
		CL = this.getClass().getClassLoader();
	}
	
	public void addImage(String name, String path) {
		IMAGE_URLS.put(name, path);
	}
	
	public void removeImage(String name) {
		if (IMAGE_URLS.containsKey(name)) IMAGE_URLS.remove(name);
		if (IMAGES.containsKey(name)) IMAGES.remove(name);
	}
	
	public void loadImage(String name) {
		
		if (IMAGE_URLS.containsKey(name) != true) {
			System.out.println("[Error] Image not stored as a URL. Cannot load.");
			return;
		}
		
		try {
			
			CURRENT_URL = CL.getResource(IMAGE_URLS.get(name));
			ImageIcon imageIcon = new ImageIcon(CURRENT_URL);
			IMAGES.put(name, imageIcon);
			
		} catch (Exception ex) {
			System.out.println("[Error] Image could not be found. " + IMAGE_URLS.get(name));
		}
		
	}
	
	public ImageIcon getImage(String name) {
		
		if (IMAGES.containsKey(name) != true) {
			System.out.println("[Error] Image not found in ImageIcon cache.");
			return null;
		}
		
		return IMAGES.get(name);
		
	}

}
