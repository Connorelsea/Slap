package com.elsea.slap.client;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class DisplayLoading extends WindowPanel {
	private static final long serialVersionUID = 1L;
	
	private JProgressBar BAR;
	private JLabel LABEL;
	
	private ImageIcon BACKGROUND;
	
	public DisplayLoading() {
		
		System.out.println("LOADING.");
		
		this.setTrackProgress(true);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		LABEL = new JLabel("New label");
		LABEL.setForeground(Color.WHITE);
		LABEL.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(LABEL, BorderLayout.NORTH);
		BAR = new JProgressBar();
		panel.add(BAR, BorderLayout.SOUTH);
		BAR.setForeground(new Color(242, 72, 72));
		
		Program.RESOURCE_MANAGER.loadImage("BACKGROUND_WOOD");
		BACKGROUND = Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD");
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				loadItems();
			}
			
		});
		
		System.out.println("DONE LOADING.");

	}
	
	public void loadItems() {
		
		System.out.println("Loading items.");
		
		//check for updates
		LABEL.setText("Checking for updates...");
		BAR.setValue(10);
		
		//load images
		LABEL.setText("Loading Images...");
		BAR.setValue(25);
		
		//load the rest of the menu panels
		LABEL.setText("Loading the menu panels...");
		
		Program.DISPLAY_MAIN_MENU = new DisplayMainMenu();
		Program.WINDOW_MANAGER.addPanel("MAIN_MENU", Program.DISPLAY_MAIN_MENU);
		
		BAR.setValue(50);
		
		//load the menu
		LABEL.setText("Loading menu...");
		BAR.setValue(65);
		
		//finalize
		LABEL.setText("Finalizing...");
		BAR.setValue(80);
		
		Program.WINDOW_MANAGER.sendProgressFinish();
		Program.WINDOW_MANAGER.setBounds(800, 500);
		Program.WINDOW_MANAGER.refreshWindow();
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(BACKGROUND.getImage(), 0, 0, null);
		
	}

}
