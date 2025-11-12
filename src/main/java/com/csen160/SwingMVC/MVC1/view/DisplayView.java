package com.csen160.SwingMVC.MVC1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import MVC1.model.ItemModel;

public class DisplayView extends AView {
	private JLabel label;

	public DisplayView() {
		setBackground(Color.CYAN);
		TitledBorder border = new TitledBorder("View With Colors");
		border.setTitleColor(Color.WHITE);
		setBorder(border);

		label = new JLabel("", SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
	}

	// This method is called when the Observable model is changed
	public void update(Observable o1, Object price) {
		ItemModel model = (ItemModel) o1;
		double oldPrice = ((Double) price).doubleValue();
		
		if (model.getPrice() < oldPrice) {
			setBackground(Color.RED);
		} else {
			setBackground(Color.BLUE);

		}
		
		label.setText(new Double(model.getPrice()).toString());
	}
}