package com.elsea.slap.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel PANEL;
	
	private String TEXT = "[Error] Text Not Set";
	private JLabel L_TEXT;
	
	private MouseListener MOUSE_LISTENER;
	private Action ACTION_CLICK;
	
	private boolean ACTIVATED = true;
	private boolean DO_COLOR_HOVER = false;
	private boolean DO_COLOR_PRESS = false;
	
	private Color COLOR_GENERAL;
	private Color COLOR_HOVER;
	private Color COLOR_DEACTIVATED;
	private Color COLOR_PRESSED;
	
	public JButtonPanel(String text, Action actionOnClick) {
		
		System.out.println("Created.");
		
		PANEL = this;
		
		ACTION_CLICK = actionOnClick;
		initiateListeners();
		
		TEXT = text;
		L_TEXT = new JLabel(TEXT);
		
		createComponent();
		
	}
	
	public void initiateListeners() {
		
		MOUSE_LISTENER = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (ACTIVATED) {
					if (COLOR_GENERAL != null) PANEL.setBackground(COLOR_GENERAL);
					ACTION_CLICK.fire();
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				if (DO_COLOR_HOVER) {
					System.out.println("Hover.");
					PANEL.setBackground(COLOR_HOVER);
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				if (DO_COLOR_HOVER) {
					System.out.println("Exit.");
					PANEL.setBackground(COLOR_GENERAL);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				if (DO_COLOR_PRESS) {
					System.out.println("Pressed.");
					PANEL.setBackground(COLOR_PRESSED);
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				if (DO_COLOR_PRESS) {
					System.out.println("Released.");
					PANEL.setBackground(COLOR_GENERAL);
				}
				
			}
			
		};
		
		this.addMouseListener(MOUSE_LISTENER);
		
	}
	
	public void createComponent() {
			
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		box.add(L_TEXT);
		box.add(Box.createHorizontalGlue());
		
		this.add(box, BorderLayout.CENTER);
		
	}
	
	public void doColorHover(boolean value) {
		DO_COLOR_HOVER = value;
	}
	
	public boolean isColorHoverOn() {
		return DO_COLOR_HOVER;
	}
	
	public void doColorPressed(boolean value) {
		DO_COLOR_PRESS = value;
	}
	
	public boolean isColorPressedOn() {
		return DO_COLOR_PRESS;
	}
	
	public void setActivationLevel(boolean value) {
		
		if (value == true) {
			
			if (COLOR_GENERAL != null) this.setBackground(COLOR_GENERAL);
			ACTIVATED = true;
			
		} else {
			
			if (COLOR_DEACTIVATED != null) this.setBackground(COLOR_DEACTIVATED);
			ACTIVATED = false;
			
		}
		
	}
	
	public void turnOnColorFunctions() {
		DO_COLOR_HOVER = true;
		DO_COLOR_PRESS = true;
	}
	
	public void turnOffColorFunctions() {
		DO_COLOR_HOVER = false;
		DO_COLOR_PRESS = false;
	}
	
	public void setColorGeneral(Color color) {
		COLOR_GENERAL = color;
		this.setBackground(COLOR_GENERAL);
	}
	
	public Color getColorGeneral() {
		return COLOR_GENERAL;
	}
	
	public void setColorHover(Color color) {
		COLOR_HOVER = color;
	}
	
	public Color getColorHover() {
		return COLOR_HOVER;
	}
	
	public void setColorDeactivated(Color color) {
		COLOR_DEACTIVATED = color;
	}

	public Color getColorDeactivated() {
		return COLOR_DEACTIVATED;
	}
	
	public void setColorPressed(Color color) {
		COLOR_PRESSED = color;
	}
	
	public Color getColorPressed() {
		return COLOR_PRESSED;
	}

}