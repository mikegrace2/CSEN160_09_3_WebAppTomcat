package com.csen160.SwingMVC.MVC1.control;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import MVC1.model.ItemModel;
import MVC1.view.AView;

/**
 * This is the model class that holds the name and price of an item
 * Extends the Observable class; allows addition (and deletion) of observers
 * and notifies them when the price changes
 */
public class ItemController implements ActionListener {
	private ItemModel itemModel;
	private JFrame appwin;
	private UIView ui;
	private JPanel viewsPanel;

	//////// An Inner class that provides the text fields and buttons for
	//////// input///////////////////////////////////////////
	@SuppressWarnings("serial")
	class UIView extends JPanel {
		private JButton incB;
		private JButton reduceB;

		@SuppressWarnings("removal")
		public UIView() {
			setBorder(new TitledBorder("User Interface for Input"));

			JLabel label1 = new JLabel("Item Name");
			add(label1);

			JTextField itemIdFld = new JTextField();
			add(itemIdFld);
			itemIdFld.setText(itemModel.getItemName());

			JLabel label2 = new JLabel("Starting Price");
			add(label2);

			JTextField itemPriceFld = new JTextField();
			add(itemPriceFld);
			itemPriceFld.setText("$" + new Double(itemModel.getPrice()).toString());

			// Add the buttons
			incB = new JButton("Increase Price");
			incB.setActionCommand("inc");
			add(incB);
			reduceB = new JButton("Reduce Price");
			reduceB.setActionCommand("dec");
			add(reduceB);
		}

		public void addListener(ActionListener listener) {
			incB.addActionListener(listener);
			reduceB.addActionListener(listener);
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////

	public ItemController(ItemModel model) {
		itemModel = model;

		// Create the frame to hold the UI (for input) to the application
		// and output views. The views are restricted to two.

		this.appwin = new JFrame("Application Window");
		ui = new UIView();
		appwin.setLayout(new BorderLayout());
		// Add the UI for input
		appwin.getContentPane().add(ui, BorderLayout.EAST);

		// Add a panel to hold upto 2 views.
		viewsPanel = new JPanel();
		viewsPanel.setLayout(new GridLayout(1, 2));
		appwin.getContentPane().add(viewsPanel, BorderLayout.WEST);
		appwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addAView(AView view) {
		viewsPanel.add(view);
	}

	public void actionPerformed(ActionEvent evt) {
		// Check where the event is coming from
		// Change the model price
		String cmd = evt.getActionCommand();
		if (cmd.equals("inc")) {
			itemModel.increasePrice(1);
		} else if (cmd.equals("dec")) {
			itemModel.decreasePrice(1);
		}
	}

	public void activateUI() {
		// Notify the controller when an event (a button click) happens
		ui.addListener(this);

		// Display the window.
		appwin.setSize(300, 300);
		appwin.setLocationRelativeTo(null);
		appwin.pack();
		appwin.setVisible(true);
	}

	public void startApp() {
		activateUI();
	}
}
