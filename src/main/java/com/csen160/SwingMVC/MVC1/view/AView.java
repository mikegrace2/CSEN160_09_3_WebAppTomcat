package com.csen160.SwingMVC.MVC1.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * This class implements the Observer interface and provides an empty implementation for the interface
 */
public class AView extends JPanel implements Observer{
	public void update(Observable o1, Object o2) {
		// Base class: do nothing
	};
}
