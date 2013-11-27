package com.elsea.slap.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSplitPane;

public class DisplayMainMenu extends JFrame {

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
		
		FlowLayout PC2_LAYOUT = new FlowLayout();
		PC2_LAYOUT.setAlignment(FlowLayout.CENTER);
		PC2_LAYOUT.setHgap(5);
		
		ColorTheme THEME_BUTTONS = new ColorTheme();
		THEME_BUTTONS.addColor("general", new Color(242, 72, 72));
		THEME_BUTTONS.addColor("pressed", new Color(216, 47, 47));
		THEME_BUTTONS.addColor("hover", new Color(249, 98, 98));
		THEME_BUTTONS.addColor("deactivated", new Color(49, 19, 19));
		
		JPanel P_CONTENT_2 = new JPanel();
		P_CONTENT_2.setLayout(PC2_LAYOUT);
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
		P_CONTENT_2.add(BP_MULTIPLAYER);
		
	}

}
