package com.elsea.slap.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayMainMenu extends WindowPanel {
	private static final long serialVersionUID = 1L;
	
	private Image BACKGROUND;

	public DisplayMainMenu() {
		
		BACKGROUND = Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD").getImage();
		
		ColorTheme THEME_BUTTONS = new ColorTheme();
		THEME_BUTTONS.addColor("general", new Color(242, 72, 72));
		THEME_BUTTONS.addColor("pressed", new Color(216, 47, 47));
		THEME_BUTTONS.addColor("hover", new Color(249, 98, 98));
		THEME_BUTTONS.addColor("deactivated", new Color(49, 19, 19));
		
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel P_BOTTOM_BAR = new JPanel();
		P_BOTTOM_BAR.setPreferredSize(new Dimension(30, 30));
		P_BOTTOM_BAR.setBackground(THEME_BUTTONS.getColor("general"));
		add(P_BOTTOM_BAR, BorderLayout.SOUTH);
		
		JPanel P_CONTENT_HOLDER = new JPanel();
		P_CONTENT_HOLDER.setOpaque(false);
		add(P_CONTENT_HOLDER, BorderLayout.CENTER);
		P_CONTENT_HOLDER.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel P_CONTENT_1 = new JPanel();
		Dimension d = new Dimension();
		d.setSize(1000, 400);
		P_CONTENT_1.setPreferredSize(d);
		P_CONTENT_1.setOpaque(false);
		P_CONTENT_HOLDER.add(P_CONTENT_1);
		
		JLabel L_LOGO = new JLabel(Program.RESOURCE_MANAGER.getImage("LOGO"));
		P_CONTENT_1.add(L_LOGO);

		Dimension DIM_BUTTON = new Dimension(200, 50);
		
		JPanel P_CONTENT_2 = new JPanel();
		P_CONTENT_2.setOpaque(false);
		P_CONTENT_2.setLayout(new BoxLayout(P_CONTENT_2, BoxLayout.Y_AXIS));
		P_CONTENT_HOLDER.add(P_CONTENT_2);
		
		P_CONTENT_2.add(Box.createRigidArea(new Dimension(40, 40)));
		
		JButtonPanel BP_MULTIPLAYER = new JButtonPanel("Multiplayer", new Action() {

			@Override
			public void definition() {
				
			}
			
		});
		BP_MULTIPLAYER.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_MULTIPLAYER.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_MULTIPLAYER.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_MULTIPLAYER.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_MULTIPLAYER.turnOnColorFunctions();
		BP_MULTIPLAYER.setMaximumSize(DIM_BUTTON);
		BP_MULTIPLAYER.setMinimumSize(DIM_BUTTON);
		P_CONTENT_2.add(BP_MULTIPLAYER);
		
		P_CONTENT_2.add(Box.createRigidArea(new Dimension(10,10)));
		
		JButtonPanel BP_TUTORIAL = new JButtonPanel("Tutorial", new Action() {

			@Override
			public void definition() {
				System.out.println("Clicked.");
			}
			
		});
		BP_TUTORIAL.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_TUTORIAL.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_TUTORIAL.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_TUTORIAL.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_TUTORIAL.turnOnColorFunctions();
		BP_TUTORIAL.setMaximumSize(DIM_BUTTON);
		BP_TUTORIAL.setMinimumSize(DIM_BUTTON);
		P_CONTENT_2.add(BP_TUTORIAL);
		
		P_CONTENT_2.add(Box.createRigidArea(new Dimension(10,10)));
		
		JButtonPanel BP_SETTINGS = new JButtonPanel("Settings", new Action() {

			@Override
			public void definition() {
				System.out.println("Clicked.");
			}
			
		});
		BP_SETTINGS.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_SETTINGS.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_SETTINGS.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_SETTINGS.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_SETTINGS.turnOnColorFunctions();
		BP_SETTINGS.setMaximumSize(DIM_BUTTON);
		BP_SETTINGS.setMinimumSize(DIM_BUTTON);
		P_CONTENT_2.add(BP_SETTINGS);
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(BACKGROUND, 0, 0, null);
		
	}

}
