package com.elsea.slap.client;

import java.util.ArrayList;

public class Log {
	
	private ArrayList<String> LOG;
	private String SECTION = "General";
	private String SECTION_SUB;
	private boolean USE_SUB_SECTION;
	
	public Log() {
		LOG = new ArrayList<String>();
	}
	
	public void log(String string) {
		LOG.add(string);
		
		if (USE_SUB_SECTION == false) {
			System.out.println("[" + SECTION + "] " + string);
		} else {
			System.out.println("[" + SECTION + " : " + SECTION_SUB + "] " + string);
		}
		
	}
	
	public void setSection(String section) {
		useSubSection(true);
		SECTION = section;
	}
	
	public void setSubSection(String sub) {
		SECTION_SUB = sub;
	}
	
	public void useSubSection(boolean value) {
		USE_SUB_SECTION = value;
	}
	
	public ArrayList<String> getArray() {
		return LOG;
	}
	
	public void clearLog() {
		LOG.clear();
	}

}