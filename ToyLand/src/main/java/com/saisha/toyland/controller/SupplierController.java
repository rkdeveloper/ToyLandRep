package com.saisha.toyland.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saisha.toyland.dao.CategoryDAO;
import com.saisha.toyland.dao.SupplierDAO;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@ModelAttribute("supplier")
	public Supplier initSupplier(){
		return new Supplier();
	}
	
	@RequestMapping(value={"getSupplier","supplier/edit/getSupplier"})
	public ModelAndView getSupplier()
	{
		List<Supplier> supplierList = supplierDAO.getSupplier();
		List<Category> categoryList = categoryDAO.getCategories();
		ModelAndView model = new ModelAndView("manageSupplier");
		model.addObject("suppliers", supplierList);
		model.addObject("categories", categoryList);
		return model;
	}
	
	@RequestMapping(value="supplier/edit/{supplierId}", method = RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable("supplierId")int id, @ModelAttribute("supplier")Supplier supplier)
	{
		System.out.println("supplier is being modified..");
		supplier=supplierDAO.getSupplier(id);
		System.out.println(supplier.getSupplierName());
		ModelAndView mv = new ModelAndView("editSupplier");
		mv.addObject("supplier", supplier);
		return mv;
	}
	
	@RequestMapping(value="supplier/edit/{supplierId}", method = RequestMethod.POST)
	public String modifySupplier(@PathVariable("supplierId")int id, @ModelAttribute("supplier")Supplier supplier)
	{
		System.out.println("supplier is being modified..");
		supplierDAO.edit(id, supplier);
		return "redirect:/getSupplier";
	}
	
	@RequestMapping(value="supplier/delete/{supplierId}", method = RequestMethod.GET)
	public String deleteSupplier(@PathVariable("supplierId")int id, @ModelAttribute("supplier")Supplier supplier)
	{
		System.out.println("supplier is being deleted..");
		supplierDAO.delete(id);
		return "redirect:/getSupplier";
	}

	@RequestMapping(value ="/addSupplier", method = RequestMethod.POST)
	public ModelAndView addSupplier (@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result, ModelMap model)
	{
		if(result.hasErrors()){
			return new ModelAndView("addSupplier");
		}
		System.out.println("adding supplier");
		supplierDAO.addNewSupplier(supplier);
		return getSupplier();
	}
}