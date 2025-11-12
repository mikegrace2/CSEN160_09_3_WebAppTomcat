package com.csen160.SwingMVC.MVC3.view;

// AccountTextView is an AbstractAccountView subclass
// that displays an Account balance in a JTextField.
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MVC3.model.Account;

@SuppressWarnings("serial")
public class AccountTextView extends AbstractAccountView {
	// JTextField for displaying Account balance
	private JTextField balanceTextField = new JTextField(10);

	// NumberFormat for US dollars
	private NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	// AccountTextView constructor
	public AccountTextView(Account account) {
		super(account);
		balanceTextField.setEditable(false); // make balanceTextField read only
		add(new JLabel("Balance: ")); // lay out components
		add(balanceTextField);
		updateDisplay();
	}

	// update display with Account balance
	public void updateDisplay() {
		// set text in balanceTextField to formatted balance
		balanceTextField.setText(moneyFormat.format(getAccount().getBalance()));
	}
}
