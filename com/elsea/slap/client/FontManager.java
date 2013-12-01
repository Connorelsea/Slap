package com.elsea.slap.client;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class FontManager {
	
	private HashMap<String, Font> FONTS;
	private Log LOG;
	
	public FontManager() {
		
		LOG = new Log();
		LOG.setSection("FontManager");
		LOG.useSubSection(false);
		
		FONTS = new HashMap<String, Font>();
	}
	
	public void loadFont(String name, String url) {
		
		// "res/fonts/THIN.ttf"
		
		Font FONT;
		
		LOG.setSubSection("Loading Font");
		LOG.log("Loading custom font.");
		URL fontURL = this.getClass().getClassLoader().getResource(url);
		
		try {
			
			FONT = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			LOG.log("Done loading custom font.");
			
		} catch (FontFormatException e) {
			
			LOG.log("FontFormatException, can't use custom font. Using native font.");
			FONT = Font.getFont(Font.SANS_SERIF);
			e.printStackTrace();
			
		} catch (IOException e) {
			
			LOG.log("FontFormatException, can't use custom font. Using native font.");
			FONT = Font.getFont(Font.SANS_SERIF);
			e.printStackTrace();
		}
		
		LOG.useSubSection(false);
	}
	
	public Font getFont(String name) {
		return FONTS.get(name);
	}

}
