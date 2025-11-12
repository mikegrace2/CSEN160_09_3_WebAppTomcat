package com.csen160.SwingMVC.MVC1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import MVC1.model.ItemModel;

public class TextView extends AView {
	private JTextArea area;
	JScrollPane scrollPane;

	public TextView() {
		setBorder(new TitledBorder("A text view"));
		area = new JTextArea("", 2, 20);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.WHITE);
		area.setLineWrap(true);
		area.setEditable(false);
		area.setFont(new Font("Serif", Font.ITALIC, 16));
		area.setWrapStyleWord(true);
		add(area, BorderLayout.CENTER);
	}

	// This method is called when the Observable model is changed
	public void update(Observable o1, Object price) {
		ItemModel model = (ItemModel) o1;
		double oldPrice = ((Double) price).doubleValue();
		String s = "";
		double currentPrice = model.getPrice();
		s = "Old Price: $" + oldPrice + "\nCurrent Price: $" + currentPrice + "\n";
		area.setText(s);
	}
}
