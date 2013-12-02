package com.elsea.slap.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class DisplayTutorial extends WindowPanel {
	public DisplayTutorial() {
	}
	private static final long serialVersionUID = 1L;

	public void build() {
		
		ColorTheme THEME_BUTTONS = new ColorTheme();
		THEME_BUTTONS.addColor("general", new Color(242, 72, 72));
		THEME_BUTTONS.addColor("pressed", new Color(216, 47, 47));
		THEME_BUTTONS.addColor("hover", new Color(249, 98, 98));
		THEME_BUTTONS.addColor("deactivated", new Color(49, 19, 19));
		
		setLayout(new BorderLayout(0, 0));
		setBorder(null);
		
		JPanel P_NORTH = new JPanel();
		P_NORTH.setPreferredSize(new Dimension(10, 30));
		P_NORTH.setBackground(new Color(242, 72, 72));
		add(P_NORTH, BorderLayout.NORTH);
		P_NORTH.setLayout(new BorderLayout(0, 0));
		
		JLabel L_TITLE = new JLabel("  Multiplayer");
		L_TITLE.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE").getName(), Font.PLAIN, 20));
		L_TITLE.setForeground(Color.WHITE);
		P_NORTH.add(L_TITLE);
		
		JPanel P_SOUTH = new JPanel();
		P_SOUTH.setPreferredSize(new Dimension(10, 30));
		P_SOUTH.setBackground(new Color(242, 72, 72));
		P_SOUTH.setLayout(new BorderLayout(0, 0));
		add(P_SOUTH, BorderLayout.SOUTH);
		
		JButtonPanel BP_BACK = new JButtonPanel("  Back  ", new Action() {

			@Override
			public void definition() {
				
				Program.WINDOW_MANAGER.sendProgressFinish();
				Program.WINDOW_MANAGER.refreshWindow();
				
			}
			
		});
		BP_BACK.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_BACK.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_BACK.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_BACK.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_BACK.setColorForeground(Color.WHITE);
		BP_BACK.setBorder(null);
		BP_BACK.setFont(Program.FONT_MANAGER.getFont("ALTE"));
		BP_BACK.setFontSize(22);
		BP_BACK.turnOnColorFunctions();
		BP_BACK.createComponent();
		P_SOUTH.add(BP_BACK, BorderLayout.WEST);
		
		JPanel P_CENTER = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD").getImage(), 0, 0, null);
			}
			
		};
		P_CENTER.setBorder(null);
		P_CENTER.setOpaque(false);
		add(P_CENTER, BorderLayout.CENTER);
		P_CENTER.setLayout(new BorderLayout(0, 0));
		
		JScrollPane P_SCROLL = new JScrollPane();
		P_SCROLL.setBorder(null);
		P_SCROLL.setOpaque(false);
		P_SCROLL.getViewport().setOpaque(false);
		P_SCROLL.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		P_CENTER.add(P_SCROLL, BorderLayout.CENTER);
		
		JTextArea TEXT_AREA = new JTextArea();
		TEXT_AREA.setOpaque(false);
		TEXT_AREA.setBorder(null);
		TEXT_AREA.setForeground(Color.WHITE);
		TEXT_AREA.setWrapStyleWord(true);
		TEXT_AREA.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE").getName(), Font.PLAIN, 20));
		P_SCROLL.setViewportView(TEXT_AREA);
		
		TEXT_AREA.setText("This is a testing string. This is a testing string. This is a testing string. This is a testing string. This is a testing string.");
		

	}

}
