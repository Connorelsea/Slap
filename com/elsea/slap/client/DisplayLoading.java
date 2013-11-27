package com.elsea.slap.client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;

public class DisplayLoading extends JPanel {
	private static final long serialVersionUID = 1L;

	public DisplayLoading() {
		setLayout(new BorderLayout(0, 0));
		
		JProgressBar progressBar = new JProgressBar();
		add(progressBar, BorderLayout.SOUTH);

	}

}
