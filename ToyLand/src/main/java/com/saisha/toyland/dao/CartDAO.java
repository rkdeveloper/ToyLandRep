package com.saisha.toyland.dao;

import java.util.List;

import com.saisha.toyland.model.Cart;

public interface CartDAO {

	public void addToCart(Cart c);
	public List<Cart> getCart();
	public Cart edit(int id, Cart c);
	public void delete(int id);
	public Cart findById(int cartId);
}