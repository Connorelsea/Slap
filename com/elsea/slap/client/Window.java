package com.elsea.slap.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel CONTENT_PANE;
	
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

}