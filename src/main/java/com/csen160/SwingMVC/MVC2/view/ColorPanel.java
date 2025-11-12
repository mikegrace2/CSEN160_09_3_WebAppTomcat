package com.csen160.SwingMVC.MVC2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.csen160.SwingMVC.MVC2.model.ColorData;

@SuppressWarnings({ "serial", "deprecation" })
public class ColorPanel extends JPanel implements Observer {
	private ColorData model;
	private String message = "Hello";
	private Font font;

	public ColorPanel(ColorData model) {
		setBackground(Color.pink);
		setLayout(new BorderLayout());
		font = new Font("Sans Serif", Font.BOLD, 25);
		
		this.model = model;
		model.addObserver(this);
	}

	public void update(Observable o, Object o1) {
		setBackground(model.getColor());
		repaint();
	}

	public void paintComponent(Graphics gp) {
		super.paintComponent(gp); // ensure proper painting sequence
		Graphics2D g = (Graphics2D) gp; // Cast the graphics objects to Graphics2D
		Dimension panelSize = getSize();
		g.setFont(font);
		g.drawString(message, panelSize.width / 2, panelSize.height / 2);
	}
}