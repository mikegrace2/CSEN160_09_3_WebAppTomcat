package com.csen160.MVC2.model;

import java.awt.Color;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class ColorData extends Observable {
	Color color = Color.black;

	public void setColor(String newColor) {
		if (newColor.equals("r"))
			color = Color.red;
		else if (newColor.equals("g"))
			color = Color.green;
		else if (newColor.equals("b"))
			color = Color.blue;
		else
			color = Color.magenta;

		// must call setChanged before notifyObservers to
		// indicate model has changed

		setChanged();
		// notify Observers that model has changed
		notifyObservers();
	}

	public Color getColor() {
		return color;
	}
}
