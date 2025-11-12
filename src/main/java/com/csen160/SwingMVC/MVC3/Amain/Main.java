package com.csen160.SwingMVC.MVC3.Amain;

import javax.swing.JFrame;

import com.csen160.SwingMVC.MVC3.control.AccountManager;

public class Main {
	public static void main(String args[]) {
		AccountManager manager = new AccountManager();
		manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manager.setVisible(true);
	}
}
