package com.elsea.slap.client;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JProgressBar;

public class DisplayLoading extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JProgressBar BAR;
	private ImageIcon BACKGROUND;
	
	public DisplayLoading() {
		
		setLayout(new BorderLayout(0, 0));
		BAR = new JProgressBar();
		BAR.setForeground(new Color(242, 72, 72));
		add(BAR, BorderLayout.SOUTH);
		
		Program.RESOURCE_MANAGER.loadImage("BACKGROUND_WOOD");
		BACKGROUND = Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD");

	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(BACKGROUND.getImage(), 0, 0, null);
		
	}

}
