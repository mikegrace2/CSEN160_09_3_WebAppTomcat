package com.csen160.SwingMVC.MVC1.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ItemModel extends Observable {
	private String itemName;
	private double price;
	
	public ItemModel (String name, double price){
		this.itemName = name; this.price = price;
	}
	
	@SuppressWarnings("removal")
	public void setPrice(double price){
		// stores the old price before changing the price to the new value
		double oldPrice = this.price;
		this.price = price;
		setChanged();
		// Passes the old price (before change)
		notifyObservers(new Double(oldPrice));
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public void increasePrice(double inc){
		setPrice(getPrice()+inc);
	}
	
	public void decreasePrice(double p){
		setPrice(getPrice()-p);
	}
}