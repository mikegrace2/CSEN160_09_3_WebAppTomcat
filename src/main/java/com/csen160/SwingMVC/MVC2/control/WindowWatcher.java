package com.csen160.SwingMVC.MVC2.control;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import MVC2.model.ColorData;
import MVC2.view.ColorPanel;

@SuppressWarnings("serial")
public class WindowWatcher extends JFrame implements ItemListener {
	//private JButton Close;
	private JRadioButton red, green, blue;
	private ColorData model;
	private ButtonGroup bgr;

	public WindowWatcher() {
		super("WindowWatcher");
		model = new ColorData();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		createButtons();
		addFlowLayout(buttonPanel);
		addListeners();
		ColorPanel cpanel = new ColorPanel(model);

		this.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(cpanel, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void createButtons() {
		red = new JRadioButton("Red");
		red.setActionCommand("r");

		green = new JRadioButton("Green");
		green.setActionCommand("g");

		blue = new JRadioButton("Blue");
		blue.setActionCommand("b");
		// make all part of same button group

		bgr = new ButtonGroup();
		bgr.add(red);
		bgr.add(green);
		bgr.add(blue);
	}

	private void addListeners() {
		blue.addItemListener(this); // listen for clicks
		red.addItemListener(this); // on radion buttons
		green.addItemListener(this);
	}

	public void addFlowLayout(JPanel panel) {
		panel.setLayout(new FlowLayout());
		panel.add(red);
		panel.add(green);
		panel.add(blue);
	}

	public void itemStateChanged(ItemEvent e) {
		// responds to radio button clicks
		// if the button is selected
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JRadioButton source = (JRadioButton) e.getSource();
			String action = source.getActionCommand();
			model.setColor(action);
		}
	}
}