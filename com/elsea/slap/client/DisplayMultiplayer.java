package com.elsea.slap.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.Font;

public class DisplayMultiplayer extends WindowPanel {
	public DisplayMultiplayer() {
	}
	private static final long serialVersionUID = 1L;

	public void build() {
		
		ColorTheme THEME_BUTTONS = new ColorTheme();
		THEME_BUTTONS.addColor("general", new Color(242, 72, 72));
		THEME_BUTTONS.addColor("pressed", new Color(216, 47, 47));
		THEME_BUTTONS.addColor("hover", new Color(249, 98, 98));
		THEME_BUTTONS.addColor("deactivated", new Color(49, 19, 19));
		
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel P_TOP = new JPanel();
		P_TOP.setPreferredSize(new Dimension(10, 30));
		P_TOP.setBackground(new Color(242, 72, 72));
		P_TOP.setBorder(null);
		add(P_TOP, BorderLayout.NORTH);
		P_TOP.setLayout(new BorderLayout(0, 0));
		
		JLabel L_TITLE = new JLabel("  Multiplayer");
		L_TITLE.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE").getName(), Font.PLAIN, 20));
		L_TITLE.setForeground(Color.WHITE);
		P_TOP.add(L_TITLE);
		
		JPanel P_BOTTOM = new JPanel();
		P_BOTTOM.setPreferredSize(new Dimension(10, 30));
		P_BOTTOM.setBackground(new Color(242, 72, 72));
		P_BOTTOM.setBorder(null);
		add(P_BOTTOM, BorderLayout.SOUTH);
		P_BOTTOM.setLayout(new BorderLayout(0, 0));
		
		//JPanel BACK_BP_HERE = new JPanel();
		//BACK_BP_HERE.setBackground(Color.DARK_GRAY);
		//P_BOTTOM.add(BACK_BP_HERE, BorderLayout.WEST);
		
		JButtonPanel BP_BACK = new JButtonPanel("  Back  ", new Action() {

			@Override
			public void definition() {
				
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
		P_BOTTOM.add(BP_BACK, BorderLayout.WEST);
		
		
		JLabel L_STATUS = new JLabel("Connecting...    ");
		L_STATUS.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE").getName(), Font.PLAIN, 14));
		L_STATUS.setForeground(Color.WHITE);
		P_BOTTOM.add(L_STATUS, BorderLayout.EAST);
		
		JPanel P_CENTER = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g) {
				g.drawImage(Program.RESOURCE_MANAGER.getImage("BACKGROUND_WOOD").getImage(), 0, 0, null);
			}
			
		};
		P_CENTER.setOpaque(false);
		P_CENTER.setBorder(null);
		add(P_CENTER, BorderLayout.CENTER);
		P_CENTER.setLayout(new BorderLayout(0, 0));
		
		JScrollPane P_SCROLL = new JScrollPane();
		P_SCROLL.setOpaque(false);
		P_SCROLL.getViewport().setOpaque(false);
		P_SCROLL.setBorder(null);
		P_SCROLL.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		P_CENTER.add(P_SCROLL, BorderLayout.CENTER);
		
		JPanel P_INFO = new JPanel();
		P_INFO.setPreferredSize(new Dimension(250, 10));
		P_INFO.setBackground(new Color(249, 98, 98));
		P_INFO.setBorder(null);
		add(P_INFO, BorderLayout.EAST);
		P_INFO.setLayout(new BorderLayout(0, 0));
		
		JPanel P_INFO_BORDER = new JPanel();
		P_INFO_BORDER.setBorder(null);
		P_INFO_BORDER.setPreferredSize(new Dimension(5, 10));
		P_INFO_BORDER.setBackground(new Color(242, 72, 72));
		P_INFO.add(P_INFO_BORDER, BorderLayout.WEST);
		
		JPanel P_INFO_RIGHT = new JPanel();
		P_INFO_RIGHT.setBorder(null);
		P_INFO.add(P_INFO_RIGHT, BorderLayout.CENTER);
		P_INFO_RIGHT.setLayout(new BorderLayout(0, 0));
		
		JPanel P_IR_TOP = new JPanel();
		P_IR_TOP.setPreferredSize(new Dimension(10, 200));
		P_IR_TOP.setBackground(Color.LIGHT_GRAY);
		P_IR_TOP.setBorder(null);
		P_INFO_RIGHT.add(P_IR_TOP, BorderLayout.NORTH);
		P_IR_TOP.setLayout(new BoxLayout(P_IR_TOP, BoxLayout.Y_AXIS));
		
		JLabel L_NAME = new JLabel(" Server Name Here");
		L_NAME.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE_BOLD").getName(), Font.PLAIN, 26));
		P_IR_TOP.add(L_NAME);
		
		JLabel L_IP = new JLabel("  127.0.1.1");
		L_IP.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE_BOLD").getName(), Font.PLAIN, 14));
		P_IR_TOP.add(L_IP);
		
		JTextPane TP_META = new JTextPane();
		TP_META.setFont(new Font(Program.FONT_MANAGER.getFont("ALTE").getName(), Font.PLAIN, 14));
		TP_META.setEditable(false);
		TP_META.setBorder(null);
		TP_META.setBackground(Color.LIGHT_GRAY);
		P_IR_TOP.add(TP_META);
		
		JPanel P_IR_BOTTOM = new JPanel();
		P_IR_BOTTOM.setBackground(Color.LIGHT_GRAY);
		P_IR_BOTTOM.setBorder(null);
		P_INFO_RIGHT.add(P_IR_BOTTOM);
		//P_IR_BOTTOM.setLayout(new BoxLayout(P_IR_BOTTOM, BoxLayout.Y_AXIS));
		
		JButtonPanel BP_SERVER_EDIT = new JButtonPanel("Edit", new Action() {

			@Override
			public void definition() {
				
			}
			
		});
		BP_SERVER_EDIT.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_SERVER_EDIT.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_SERVER_EDIT.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_SERVER_EDIT.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_SERVER_EDIT.setColorForeground(Color.WHITE);
		BP_SERVER_EDIT.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		BP_SERVER_EDIT.setFont(Program.FONT_MANAGER.getFont("ALTE"));
		BP_SERVER_EDIT.setFontSize(22);
		BP_SERVER_EDIT.turnOnColorFunctions();
		BP_SERVER_EDIT.setPreferredSize(new Dimension(104, 42));
		BP_SERVER_EDIT.createComponent();
		P_IR_BOTTOM.add(BP_SERVER_EDIT);
		
		P_IR_BOTTOM.add(Box.createRigidArea(new Dimension(10,10)));
		
		JButtonPanel BP_SERVER_REFRESH = new JButtonPanel("Refresh", new Action() {

			@Override
			public void definition() {
				
			}
			
		});
		BP_SERVER_REFRESH.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_SERVER_REFRESH.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_SERVER_REFRESH.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_SERVER_REFRESH.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_SERVER_REFRESH.setColorForeground(Color.WHITE);
		BP_SERVER_REFRESH.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		BP_SERVER_REFRESH.setFont(Program.FONT_MANAGER.getFont("ALTE"));
		BP_SERVER_REFRESH.setFontSize(22);
		BP_SERVER_REFRESH.turnOnColorFunctions();
		BP_SERVER_REFRESH.setPreferredSize(new Dimension(104, 42));
		BP_SERVER_REFRESH.createComponent();
		P_IR_BOTTOM.add(BP_SERVER_REFRESH);
		
		JButtonPanel BP_SERVER_REMOVE = new JButtonPanel("Remove", new Action() {

			@Override
			public void definition() {
				
			}
			
		});
		BP_SERVER_REMOVE.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_SERVER_REMOVE.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_SERVER_REMOVE.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_SERVER_REMOVE.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_SERVER_REMOVE.setColorForeground(Color.WHITE);
		BP_SERVER_REMOVE.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		BP_SERVER_REMOVE.setFont(Program.FONT_MANAGER.getFont("ALTE"));
		BP_SERVER_REMOVE.setFontSize(22);
		BP_SERVER_REMOVE.turnOnColorFunctions();
		BP_SERVER_REMOVE.setPreferredSize(new Dimension(104, 42));
		BP_SERVER_REMOVE.createComponent();
		P_IR_BOTTOM.add(BP_SERVER_REMOVE);
		
		P_IR_BOTTOM.add(Box.createRigidArea(new Dimension(10,10)));
		
		JButtonPanel BP_SERVER_JOIN = new JButtonPanel("Join", new Action() {

			@Override
			public void definition() {
				
			}
			
		});
		BP_SERVER_JOIN.setColorGeneral(THEME_BUTTONS.getColor("general"));
		BP_SERVER_JOIN.setColorPressed(THEME_BUTTONS.getColor("pressed"));
		BP_SERVER_JOIN.setColorHover(THEME_BUTTONS.getColor("hover"));
		BP_SERVER_JOIN.setColorDeactivated(THEME_BUTTONS.getColor("deactivated"));
		BP_SERVER_JOIN.setColorForeground(Color.WHITE);
		BP_SERVER_JOIN.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		BP_SERVER_JOIN.setFont(Program.FONT_MANAGER.getFont("ALTE"));
		BP_SERVER_JOIN.setFontSize(22);
		BP_SERVER_JOIN.turnOnColorFunctions();
		BP_SERVER_JOIN.setPreferredSize(new Dimension(104, 42));
		BP_SERVER_JOIN.createComponent();
		P_IR_BOTTOM.add(BP_SERVER_JOIN);

	}

}
