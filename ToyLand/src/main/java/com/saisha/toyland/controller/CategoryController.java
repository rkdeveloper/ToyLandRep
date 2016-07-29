package com.saisha.toyland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@ModelAttribute("category")
	public Category initCategory(){
		return new Category();
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category category, ModelMap model) {
		categoryDAO.addNewCategory(category);
		return getCategory();
	}
	
	@RequestMapping(value={"getCategory","category/edit/getCategory"})
	public ModelAndView getCategory()
	{
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("manageCategories");
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping(value="category/edit/{categoryId}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("categoryId")int id, @ModelAttribute("category")Category category)
	{
		System.out.println("category is being modified..");
		category=categoryDAO.getCategory(id);
		System.out.println(category.getCategoryName());
		ModelAndView mv = new ModelAndView("editCategory");
		mv.addObject("category",category);
		return mv;
	}
	
	@RequestMapping(value="category/edit/{categoryId}", method = RequestMethod.POST)
	public String modifyCategory(@PathVariable("categoryId")int id, @ModelAttribute("category")Category category)
	{
		System.out.println("category is being modified..");
		categoryDAO.edit(id, category);
		return "redirect:/getCategory";
	}
	
	@RequestMapping(value="category/delete/{categoryId}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("categoryId")int id, @ModelAttribute("category")Category category)
	{
		System.out.println("category is being deleted..");
		categoryDAO.delete(id);
		return "redirect:/getCategory";
	}
}