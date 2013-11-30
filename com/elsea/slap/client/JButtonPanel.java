package com.elsea.slap.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  <b>JButtonPanel.class</b></br>
 *  <i>A custom component that acts a single-colored, clickable JPanel.</i></br>
 *  </br>
 *  A custom component that acts a single-color, clickable JPanel.
 *  The ability to change color during certain mouse actions, and
 *  deactivate and activate the clickability of the panel are
 *  supported.</br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
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
	
	private Color COLOR_FOREGROUND;
	private Color COLOR_GENERAL;
	private Color COLOR_HOVER;
	private Color COLOR_DEACTIVATED;
	private Color COLOR_PRESSED;
	
	private Font FONT;
	private int FONT_SIZE = 18;
	
	/**
	 *  <b>JButtonPanel()</b></br>
	 *  <i>The constructor for the JButtonPanel class. Various object
	 *  from inside of the class are instantiated, and creation methods
	 *  are fired upon the construction of JButtonPanel.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param text The text the panel should display.
	 *  @param actionOnClick The action that the button should do when clicked.
	 */
	public JButtonPanel(String text, Action actionOnClick) {
		
		PANEL = this;
		ACTION_CLICK = actionOnClick;
		initiateListeners();
		
		TEXT = text;
		L_TEXT = new JLabel(TEXT);
		
	}
	
	/**
	 *  <b>initiateListeners()</b></br>
	 *  <i>Create the MouseListener to be applied to the panel. Color changing
	 *  as well as clicking actions are set up in this method.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
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
					PANEL.setBackground(COLOR_HOVER);
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				if (DO_COLOR_HOVER) {
					PANEL.setBackground(COLOR_GENERAL);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				if (DO_COLOR_PRESS) {
					PANEL.setBackground(COLOR_PRESSED);
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				if (DO_COLOR_PRESS) {
					PANEL.setBackground(COLOR_GENERAL);
				}
				
			}
			
		};
		
		this.addMouseListener(MOUSE_LISTENER);
		
	}
	
	/**
	 *  <b>addImage()</b></br>
	 *  <i>Creates a panel and centers specified text inside of it.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void createComponent() {
			
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		
		L_TEXT.setFont(FONT);
		System.out.println("FONT NAME: " + FONT.getName() + " , SIZE: " + FONT_SIZE);
		L_TEXT.setFont(new Font(FONT.getName(), Font.PLAIN, FONT_SIZE));
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
	
	public void setColorForeground(Color color) {
		COLOR_FOREGROUND = color;
		L_TEXT.setForeground(COLOR_FOREGROUND);
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
	
	public void setFont(Font font) {
		FONT = font;
	}
	
	public void setFontSize(int i) {
		FONT_SIZE = i;
	}

}