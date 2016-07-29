package com.saisha.toyland.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saisha.toyland.dao.AuthorityDAO;
import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.dao.UserDAO;
import com.saisha.toyland.model.Authority;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AuthorityDAO authorityDAO;

	@Autowired
	CategoryDAO categoryDAO;
	
	@ModelAttribute("user")
	public User initUser() {
		return new User();
	}
	
	@RequestMapping (value = "/validateUser", method = RequestMethod.POST)
	public ModelAndView getUser(@ModelAttribute("user") User user, ModelMap model){
		System.out.println(user.getUsername());
		boolean flag = userDAO.getUser(user);
		if(flag)
		{
			List<Category> categoryList = categoryDAO.getCategories();
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("categories", categoryList);
			return mv;
		}
		else
		{
			List<Category> categoryList = categoryDAO.getCategories();
			ModelAndView mv = new ModelAndView("invcre");
			mv.addObject("categories", categoryList);
			return mv;
		}
	}
	
	@RequestMapping(value="/perform_logout")
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("user is logging out");
		if(auth != null){
			System.out.println("user is logging out");
			new SecurityContextLogoutHandler().logout(request,response, auth);
		}
		return new ModelAndView("redirect:/newlogin?logout");
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		Authority authority = authorityDAO.getAuthorityById(2);
		user.setAuthority(authority);
		if(result.hasErrors()){
			return new ModelAndView("newsignup");
		}
		userDAO.addNewUser(user);
		return new ModelAndView("newlogin");
	}
}
