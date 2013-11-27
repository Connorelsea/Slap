package com.elsea.slap.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel CONTENT_PANE;
	
	private int BOUNDS_LENGTH;
	private int BOUNDS_WIDTH;
	
	public void setBoundaries(int length, int width) {
		BOUNDS_LENGTH = length;
		BOUNDS_WIDTH = width;
	}
	
	public void updateBoundaries() {
		this.setBounds(100, 100, BOUNDS_LENGTH, BOUNDS_WIDTH);
	}
	
	public void createContentPane() {
		CONTENT_PANE = new JPanel();
		CONTENT_PANE.setBorder(null);
		CONTENT_PANE.setLayout(new BorderLayout());
	}
	
	public void setCurrentPanel(JPanel panel) {
		
		createContentPane();
		this.setContentPane(CONTENT_PANE);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	public JPanel getContentPanel() {
		return CONTENT_PANE;
	}
	
	public int getBoundLength() {
		return BOUNDS_LENGTH;
	}
	
	public int getBoundWidth() {
		return BOUNDS_WIDTH;
	}

}