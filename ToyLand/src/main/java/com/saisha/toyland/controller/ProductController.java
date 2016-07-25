package com.saisha.toyland.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.saisha.toyland.dao.CartDAO;
import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.dao.ProductDAO;
import com.saisha.toyland.model.Cart;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Product;
import com.saisha.toyland.model.Supplier;

@Controller
public class ProductController {

	
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
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request, ModelMap model) {
		System.out.println("adding product");
		productDAO.addNewProduct(product);
		
		File file = new File(request.getServletContext().getRealPath("/resources/images/")+ product.getProductId()+".jpg");//---in server
		System.out.println(request.getServletContext().getRealPath("/resources/images/")+ product.getProductId()+".jpg");
		System.out.println(file.getAbsolutePath() + " " + file.getName());
		if(!product.getImg().isEmpty())	 
		try {
			FileUtils.writeByteArrayToFile(file, product.getImg().getBytes());
			System.out.println("File Uploaded");
		} catch (IOException e) {
		e.printStackTrace();
		}	
		
		return getProduct();
	}
	
	@RequestMapping(value={"getProduct","product/edit/getProduct"})
	public ModelAndView getProduct()
	{
		List<Product> productList = productDAO.getProducts();
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("manageProduct");
		model.addObject("categories", categoryList);
		model.addObject("products", productList);
		return model;
	}
	
	@RequestMapping(value="product/edit/{productId}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("productId")int id, @ModelAttribute("product")Product product)
	{
		
//		File file = new File(request.getServletContext().getRealPath("/resources/images/")+ product.getProductId()+".jpg");//---in server
//		System.out.println(request.getServletContext().getRealPath("/resources/images/")+ product.getProductId()+".jpg");
//		System.out.println(file.getAbsolutePath() + " " + file.getName());
//		if(!product.getImg().isEmpty())	 
//		try {
//			FileUtils.writeByteArrayToFile(file, product.getImg().getBytes());
//			System.out.println("File Uploaded");
//		} catch (IOException e) {
//		e.printStackTrace();
//		}
		System.out.println("product is being modified..");
		product=productDAO.getProduct(id);
		System.out.println(product.getProductName());
		ModelAndView mv = new ModelAndView("editProduct");
		mv.addObject("product",product);
		return mv;
	}
	
	@RequestMapping(value="product/edit/{productId}", method = RequestMethod.POST)
	public String modifyProduct(@PathVariable("productId")int id, @ModelAttribute("product")Product product)
	{
		System.out.println("product is being modified..");
		productDAO.edit(id, product);
		return "redirect:/getProduct";
	}
	
	@RequestMapping(value="product/delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId")int id, @ModelAttribute("product")Product product)
	{
		System.out.println("product is being deleted..");
		productDAO.delete(id);
		return "redirect:/getProduct";
	}
	
	@RequestMapping(value="productdetails/{productId}", method = RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable("productId")int id, @ModelAttribute("product")Product product)
	{
		product = productDAO.getProduct(id);
		ModelAndView mv = new ModelAndView("toyDetails");
		mv.addObject("product",product);
		return mv;
	}
}