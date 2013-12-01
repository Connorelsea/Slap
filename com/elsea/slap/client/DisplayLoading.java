package com.elsea.slap.client;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DisplayLoading extends WindowPanel {
	private static final long serialVersionUID = 1L;
	
	private JProgressBar BAR;
	private JLabel LABEL;
	
	private ImageIcon BACKGROUND;
	
	public void build() {
		
		Program.RESOURCE_MANAGER.addImage("BACKGROUND_WOOD", "res/images/WOOD.jpg");
		Program.RESOURCE_MANAGER.loadImage("BACKGROUND_WOOD");
		BACKGROUND = Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD");
		
		this.setTrackProgress(true);
		
		setLayout(new BorderLayout(0, 0));
		setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		LABEL = new JLabel("Loading Slap...");
		LABEL.setForeground(Color.WHITE);
		LABEL.setHorizontalAlignment(SwingConstants.CENTER);
		LABEL.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
		panel.add(LABEL, BorderLayout.NORTH);
		BAR = new JProgressBar();
		BAR.setBorder(null);
		panel.add(BAR, BorderLayout.SOUTH);
		BAR.setForeground(new Color(242, 72, 72));

	}
	
	public void loadItems() {
		
		//check for updates
		LABEL.setText("Checking for updates...");
		BAR.setValue(10);
		
		LABEL.setText("Loading Fonts...");
		
		Program.FONT_MANAGER.loadFont("THIN", "res/fonts/THIN.ttf");
		Program.FONT_MANAGER.loadFont("ALTE", "res/fonts/ALTE.ttf");
		Program.FONT_MANAGER.loadFont("ALTE_BOLD", "res/fonts/ALTE_BOLD.ttf");
		
		//load images
		LABEL.setText("Loading Image URLs...");
		
		Program.RESOURCE_MANAGER.addImage("LOGO", "res/images/LOGO.png");
		
		BAR.setValue(35);
		
		LABEL.setText("Loading necessary ImageIcons...");
		
		Program.RESOURCE_MANAGER.loadImage("LOGO");
		Program.RESOURCE_MANAGER.loadImage("CARD");
		
		BAR.setValue(40);
		
		//load the rest of the menu panels
		LABEL.setText("Loading the menu panels...");
		
		Program.DISPLAY_MAIN_MENU = new DisplayMainMenu();
		Program.WINDOW_MANAGER.addPanel("MAIN_MENU", Program.DISPLAY_MAIN_MENU);
					
		Program.DISPLAY_MULTIPLAYER = new DisplayMultiplayer();
		Program.WINDOW_MANAGER.addPanel("MULTIPLAYER", Program.DISPLAY_MULTIPLAYER);
		
		Program.DISPLAY_TUTORIAL = new DisplayTutorial();
		Program.WINDOW_MANAGER.addPanel("TUTORIAL", Program.DISPLAY_TUTORIAL);
		
		BAR.setValue(60);
		
		//load the menu
		LABEL.setText("Loading menu...");
		BAR.setValue(70);
		
		//finalize
		LABEL.setText("Finalizing...");
		BAR.setValue(80);
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(BACKGROUND.getImage(), 0, 0, null);
		
	}

}
