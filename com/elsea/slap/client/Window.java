package com.elsea.slap.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  <b>Window.class</b></br>
 *  <i>An extension of the JFrame class in order to add custom functionality to frames.</i></br>
 *  </br>
 *  An extension of the JFrame class in order to add custom functionality to frames,
 *  such as better managed boundary setting, and the ability to use one frame to
 *  display multiple panels. </br>
 * 
 * 	@creator Connor Elsea
 *  @author Elsea Labs
 *  @version Slap 0.1
 *
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel CONTENT_PANE;
	
	private int BOUNDS_LENGTH;
	private int BOUNDS_WIDTH;
	
	/**
	 *  <b>setBoundaries()</b></br>
	 *  <i>Sets the variables that hold the (Integer) size of the Window.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
	 *  @param length Length of the window.
	 *  @param width Width of the window.
	 */
	public void setBoundaries(int length, int width) {
		System.out.println("4");
		BOUNDS_LENGTH = length;
		BOUNDS_WIDTH = width;
	}
	
	/**
	 *  <b>updateBoundaries()</b></br>
	 *  <i>Actually changes the size of the Window according to the previously
	 *  set length and width. Set the length and width with setBoundaries().</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void updateBoundaries() {
		
		System.out.println("5");
		
		if (Program.WINDOW_MANAGER != null) {
			
			this.setBounds(
				Program.WINDOW_MANAGER.getScreenWidth() / 2 - this.getSize().width / 2,
				Program.WINDOW_MANAGER.getScreenHeight() / 2 - this.getSize().height / 2,
				BOUNDS_LENGTH,
				BOUNDS_WIDTH
			);
			this.setLocationRelativeTo(null);
			
		} else {
			this.setBounds(10, 10, BOUNDS_LENGTH, BOUNDS_WIDTH);
		}
	}
	
	/**
	 *  <b>createContentPane()</b></br>
	 *  <i>Re-creates the global JPanel object for this class that acts as
	 *  a content pane.</i></br>
 	 *  
 	 *  @version Slap 0.1
	 */
	public void createContentPane() {
		CONTENT_PANE = new JPanel();
		CONTENT_PANE.setBorder(null);
		CONTENT_PANE.setLayout(new BorderLayout());
	}
	
	/**
	 *  <b>setCurrentPanel()</b></br>
	 *  <i>Refreshes the global content pane object and then adds the panel
	 *  specified as an argument to said content pane. In turn, this makes
	 *  the window display the contents of the specified panel.</i></br>
 	 *  
 	 *  @version Slap 0.1
 	 *  
 	 *  @param panel The panel that the window will display.
	 */
	public void setCurrentPanel(JPanel panel) {
		
		createContentPane();
		this.setContentPane(CONTENT_PANE);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	public JPanel getContentPanel() {
		return CONTENT_PANE;
	}
	
	public int getBoundLength() {
		return BOUNDS_LENGTH;
	}
	
	public int getBoundWidth() {
		return BOUNDS_WIDTH;
	}

}