package com.huel.model;

import java.util.LinkedList;
public class ShoppingCart {
	LinkedList<ShoppingCartItem> shoppingList = new LinkedList<ShoppingCartItem>();
	float tatalPrice = 0;

	public LinkedList<ShoppingCartItem> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(LinkedList<ShoppingCartItem> shoppingList) {
		this.shoppingList = shoppingList;
	}

	public float getTatalPrice() {
		return tatalPrice;
	}

	public void setTatalPrice(float tatalPrice) {
		this.tatalPrice = tatalPrice;
	}

}
