package com.saisha.toyland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.dao.ProductDAO;
import com.saisha.toyland.dao.SupplierDAO;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Product;
import com.saisha.toyland.model.Supplier;
import com.saisha.toyland.model.User;

@Controller
public class ToyController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	ProductDAO productDAO;

	@ModelAttribute("user")
	public User initUser() {
		return new User();
	}

	@ModelAttribute("category")
	public Category initCategory() {
		return new Category();
	}

	@ModelAttribute("supplier")
	public Supplier initSupplier() {
		return new Supplier();
	}

	@ModelAttribute("product")
	public Product initProduct() {
		return new Product();
	}
	
	@RequestMapping("/")
	public ModelAndView indexPage() {
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("index");
		model.addObject("categories", categoryList);
		return model;
	}

	@RequestMapping("/getAboutUs")
	public ModelAndView getAboutUs() {
		ModelAndView model = new ModelAndView("aboutus");
		List<Category> categoryList = categoryDAO.getCategories();
		model.addObject("categories", categoryList);
		return model;
	}

	@RequestMapping("/getContactUs")
	public ModelAndView getContactUs() {
		ModelAndView model = new ModelAndView("contactus");
		List<Category> categoryList = categoryDAO.getCategories();
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping("/getBilling")
	public ModelAndView getBilling() {
		ModelAndView model = new ModelAndView("billing");
		List<Category> categoryList = categoryDAO.getCategories();
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping("/getCart")
	public ModelAndView getCart() {
		ModelAndView model = new ModelAndView("cart");
		List<Category> categoryList = categoryDAO.getCategories();
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory() {
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("addCategory");
		model.addObject("categories", categoryList);
		return model;
	}

	@RequestMapping("/allToys")
	public ModelAndView allToys() {
		ModelAndView model = new ModelAndView("allToys");
		List<Category> categoryList = categoryDAO.getCategories();
		List<Product> products = productDAO.getProducts();
		model.addObject("categories", categoryList);
		model.addObject("products", products.toString());  //toString method is used for angular js
		return model;
	}

	@RequestMapping("/getLogin")
	public ModelAndView getLogin() {
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("newlogin");
		model.addObject("categories", categoryList);
		return model;
	}

	@RequestMapping("/getSignUp")
	public ModelAndView getSignUp() {
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("newsignup");
		model.addObject("categories", categoryList);
		return model;
	}

	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier() {
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("addSupplier");
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, ModelMap model) {
		ModelAndView mv = new ModelAndView("addProduct");
		List<Category> categoryList = categoryDAO.getCategories();
		List<Supplier> supplierList = supplierDAO.getSupplier();
		mv.addObject("categories", categoryList);
		mv.addObject("suppliers", supplierList);
		return mv;
	}
	
	@RequestMapping("/getAllProduct")
	public ModelAndView getAllProduct() {
		ModelAndView model = new ModelAndView("addProduct");
		List<Category> categoryList = categoryDAO.getCategories();
		model.addObject("categories", categoryList);
		System.out.println(categoryList.size());
		return model;
	}
}