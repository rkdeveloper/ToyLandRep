package com.saisha.toyland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saisha.toyland.dao.CartDAO;
import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.dao.ProductDAO;
import com.saisha.toyland.model.Cart;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Product;
import com.saisha.toyland.model.Supplier;

@Controller
public class CartController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@ModelAttribute("product")
	public Product initProduct(){
		return new Product();
	}
	
	@ModelAttribute("cart")
	public Cart initCart(){
		return new Cart();
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		 binder.registerCustomEditor(Category.class,  new ProductPropertyEditor(productDAO));
 		 binder.registerCustomEditor(Supplier.class,  new ProductPropertyEditor(productDAO));
	}
	
	@RequestMapping(value="/user/addtocart", method = RequestMethod.POST)
	public ModelAndView addToCart(@ModelAttribute Cart cart,@RequestParam("productId")int productId, @RequestParam("quantity")int quantity)
	{
		System.out.println("adding to cart..");
		cart.setProductId(productId);
		cartDAO.addToCart(cart);
		List<Cart> cartList = cartDAO.getCart();
		ModelAndView model = new ModelAndView("/flow/cart");
		model.addObject("cartList",cartList);
		model.addObject("cartId",cart.getCartId());
		return model;
	}
	
	@RequestMapping(value="/user/viewcart")
	public ModelAndView viewCart(@ModelAttribute Cart c)
	{
		ModelAndView model = new ModelAndView("/flow/cart");
		List<Category> categoryList = categoryDAO.getCategories();
		List<Cart> cartList = cartDAO.getCart();
		model.addObject("cartList",cartList);
		model.addObject("cartId",c.getCartId());
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping(value={"/collectbillinginfo","/user/collectbillinginfo"})
	public String collectBilling(@RequestParam("cartId") int cartId, @ModelAttribute("cart") Cart cart)
	{
//		Cart mycart = cartService.findById(cartId);
//		System.out.println(mycart);
		return "redirect:/cart?cartId="+cartId;
	}
	
	
//	@RequestMapping(value="cart/edit/{cartId}", method = RequestMethod.GET)
//	public ModelAndView editCart(@PathVariable("cartId")int id, @ModelAttribute("cart")Cart cart)
//	{
//		cart = (Cart) cartDAO.getCart();
//		ModelAndView mv = new ModelAndView("toyDetails");
//		mv.addObject("cart",cart);
//		return mv;
//	}
	
	@RequestMapping(value="cart/edit/{cartId}", method = RequestMethod.GET)
	public String editCart(@PathVariable("cartId")int id, @ModelAttribute("cart")Cart cart)
	{
		System.out.println("controller says cart item is being changed..");
		cartDAO.edit(id, cart);
		return "redirect:/productdetails/{productId}";
	}

	@RequestMapping(value="/user/cart/delete/{cartId}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable("cartId")int id, @ModelAttribute("cart")Cart cart)
	{
		System.out.println("controller says cart item is being deleted..");
		cartDAO.delete(id);
		return "redirect:/user/viewcart";
	}
}