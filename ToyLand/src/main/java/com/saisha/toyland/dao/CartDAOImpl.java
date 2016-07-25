package com.saisha.toyland.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saisha.toyland.model.Cart;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Product;

@Transactional
@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	SessionFactory mysessionFactory;

	public void addToCart(Cart c) {
		Session session = mysessionFactory.openSession();
		int productid = c.getProductId();
		Product pd = (Product)session.get(Product.class,productid);
		double price = pd.getProductPrice();
		c.setPrice(price);
		c.setProductName(pd.getProductName());
		session.saveOrUpdate(c);
		System.out.println("item is being added to the cart!!");
	}

	public List<Cart> getCart() {
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(Cart.class);
		List<Cart> cartList = criteria.list();
		session.close();
		return cartList;
	}
	
	public Cart findById(int cartId) {
		Session session = mysessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class, cartId);
		if(cart!=null)
			return cart;
		else
		return null;
	}
	
	public String modifyCart(Cart cart) {
		System.out.println("Updating Cart");
		Session session=mysessionFactory.openSession();
		
		Criteria c = session.createCriteria(Cart.class);
		//c.add(Restrictions.eq("userId", cart.getUserId()));
		List<Cart> cartUser = c.list();
		System.out.println(cartUser);
		for(Cart mycart : cartUser)
		{
			mycart.setAreaName(cart.getAreaName());
			mycart.setBuildingName(cart.getBuildingName());
			mycart.setCity(cart.getCity());
			mycart.setContactNumber(cart.getContactNumber());
			mycart.setFloor(cart.getFloor());
			mycart.setLandmark(cart.getLandmark());
			mycart.setPincode(cart.getPincode());
			mycart.setState(cart.getState());
			session.update(mycart);
			
//			Product p = new ProductDAOImpl().getProduct(cart.getProductId());
//			p.setStock(p.getStock() - mycart.getQuantity());
//			session.update(p);
		}
		//session.saveOrUpdate(cart);
		session.flush();
		return "success";
	}
	public Cart edit(int id, Cart cart) {
		 System.out.println("cart item is being changed..");
		 Session session = mysessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Cart c = (Cart)session.get(Cart.class, id);
		 c.setQuantity(c.getQuantity());
		 session.saveOrUpdate(c);
		 tx.commit();
		 session.close();
		 return c;
	}

	public void delete(int id) {
		System.out.println("cart item is being deleted..");
		Session session = mysessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart c = (Cart)session.load(Cart.class, id);
		session.delete(c);
		tx.commit();
		session.close();
	}
}