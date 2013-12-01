package com.elsea.slap.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;

public class DisplayMultiplayer extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisplayMultiplayer() {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel P_TOP = new JPanel();
		P_TOP.setPreferredSize(new Dimension(10, 30));
		P_TOP.setBackground(new Color(242, 72, 72));
		P_TOP.setBorder(null);
		add(P_TOP, BorderLayout.NORTH);
		P_TOP.setLayout(new BorderLayout(0, 0));
		
		JLabel L_TITLE = new JLabel("  Multiplayer");
		L_TITLE.setFont(new Font("Dialog", Font.PLAIN, 14));
		L_TITLE.setForeground(Color.WHITE);
		P_TOP.add(L_TITLE);
		
		JPanel P_BOTTOM = new JPanel();
		P_BOTTOM.setPreferredSize(new Dimension(10, 30));
		P_BOTTOM.setBackground(new Color(242, 72, 72));
		P_BOTTOM.setBorder(null);
		add(P_BOTTOM, BorderLayout.SOUTH);
		P_BOTTOM.setLayout(new BorderLayout(0, 0));
		
		JPanel BACK_BP_HERE = new JPanel();
		BACK_BP_HERE.setBackground(Color.DARK_GRAY);
		P_BOTTOM.add(BACK_BP_HERE, BorderLayout.WEST);
		
		JLabel L_STATUS = new JLabel("Connecting...");
		L_STATUS.setForeground(Color.WHITE);
		P_BOTTOM.add(L_STATUS, BorderLayout.EAST);
		
		JPanel P_CENTER = new JPanel();
		P_CENTER.setBorder(null);
		add(P_CENTER, BorderLayout.CENTER);
		P_CENTER.setLayout(new BorderLayout(0, 0));
		
		JScrollPane P_SCROLL = new JScrollPane();
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
		
		JLabel L_NAME = new JLabel("Server Name");
		L_NAME.setFont(new Font("Dialog", Font.PLAIN, 20));
		P_IR_TOP.add(L_NAME);
		
		JLabel L_IP = new JLabel("New label");
		P_IR_TOP.add(L_IP);
		
		JTextPane TP_META = new JTextPane();
		TP_META.setEditable(false);
		TP_META.setBorder(null);
		TP_META.setBackground(Color.LIGHT_GRAY);
		P_IR_TOP.add(TP_META);
		
		JPanel P_IR_BOTTOM = new JPanel();
		P_IR_BOTTOM.setBackground(Color.LIGHT_GRAY);
		P_IR_BOTTOM.setBorder(null);
		P_INFO_RIGHT.add(P_IR_BOTTOM);
		P_IR_BOTTOM.setLayout(new BoxLayout(P_IR_BOTTOM, BoxLayout.Y_AXIS));

	}

}
