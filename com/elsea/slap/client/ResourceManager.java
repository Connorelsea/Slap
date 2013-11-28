package com.elsea.slap.client;

import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 *  <b>ResourceManager.class</b></br>
 *  <i>A class intended to hold all image resources in a program.</i></br>
 *  </br>
 *  A class intended to hold all image resources in a program.
 *  Images aren't fully loaded until needed, yet their paths
 *  are stored as strings so they can be easily found during
 *  later programming. This is for resource stored inside of
 *  the JAR file.</br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
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
	
	/**
	 *  <b>addImage()</b></br>
	 *  <i>Add an image path to the URL map.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param name The name to be assigned to the image.
	 *  @param path The path to the specific image.
	 */
	public void addImage(String name, String path) {
		System.out.println("[Image] Adding URL \"" + name + "\" AT PATH \"" + path + "\"");
		
		IMAGE_URLS.put(name, path);
	}
	
	/**
	 *  <b>removeImage()</b></br>
	 *  <i>Remove an image from the URL map and the ImageIcon map.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param name The name of the image to be removed.
	 */
	public void removeImage(String name) {
		if (IMAGE_URLS.containsKey(name)) IMAGE_URLS.remove(name);
		if (IMAGES.containsKey(name)) IMAGES.remove(name);
	}
	
	/**
	 *  <b>loadImage()</b></br>
	 *  <i>Load an image as an ImageIcon from a path stored in the URL map.
	 *  The image will be stored in the ImageIcon map and can be retrieved
	 *  using getImage().</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param name The name of the path to have an image loaded from.
	 */
	public void loadImage(String name) {
		
		if (IMAGE_URLS.containsKey(name) != true) {
			System.out.println("[Error] Image not stored as a URL. Cannot load. \"" + name + "\"");
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
	
	/**
	 *  <b>getImage()</b></br>
	 *  <i>Retrieves a previously loaded image from the ImageIcon map.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param name The name of the image to be retrieved.
	 */
	public ImageIcon getImage(String name) {
		
		if (IMAGES.containsKey(name) != true) {
			System.out.println("[Error] Image not found in ImageIcon cache.");
			return null;
		}
		
		return IMAGES.get(name);
		
	}

}
