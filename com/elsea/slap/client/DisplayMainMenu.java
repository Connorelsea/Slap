package com.elsea.slap.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class DisplayMainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel CONTENT_PANE;

	/**
	 * TESTING UI
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayMainMenu frame = new DisplayMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DisplayMainMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		
		CONTENT_PANE = new JPanel();
		CONTENT_PANE.setBorder(null);
		setContentPane(CONTENT_PANE);
		CONTENT_PANE.setLayout(new BorderLayout(0, 0));
		
		JPanel P_BOTTOM_BAR = new JPanel();
		P_BOTTOM_BAR.setBackground(new Color(250, 128, 114));
		CONTENT_PANE.add(P_BOTTOM_BAR, BorderLayout.SOUTH);
		
		JPanel P_CONTENT_HOLDER = new JPanel();
		CONTENT_PANE.add(P_CONTENT_HOLDER, BorderLayout.CENTER);
		P_CONTENT_HOLDER.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel P_CONTENT_1 = new JPanel();
		P_CONTENT_HOLDER.add(P_CONTENT_1);
		
		JLabel L_LOGO = new JLabel("Logo Image Will Be Here");
		P_CONTENT_1.add(L_LOGO);

		Dimension DIM_BUTTON = new Dimension(200, 50);
		
		ColorTheme THEME_BUTTONS = new ColorTheme();
		THEME_BUTTONS.addColor("general", new Color(242, 72, 72));
		THEME_BUTTONS.addColor("pressed", new Color(216, 47, 47));
		THEME_BUTTONS.addColor("hover", new Color(249, 98, 98));
		THEME_BUTTONS.addColor("deactivated", new Color(49, 19, 19));
		
		JPanel P_CONTENT_2 = new JPanel();
		P_CONTENT_2.setLayout(new BoxLayout(P_CONTENT_2, BoxLayout.Y_AXIS));
		P_CONTENT_HOLDER.add(P_CONTENT_2);
		
		JButtonPanel BP_MULTIPLAYER = new JButtonPanel("Multiplayer", new Action() {

			@Override
			public void definition() {
				System.out.println("Clicked.");
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
		
		JButtonPanel BP_SETTINGS = new JButtonPanel("Tutorial", new Action() {

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

}
