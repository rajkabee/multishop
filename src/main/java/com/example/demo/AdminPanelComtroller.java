package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.entities.ProductCategory;
import com.example.demo.model.repos.ProductCategoryRepository;
import com.example.demo.model.repos.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdminPanelComtroller {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductCategoryRepository categoryRepo;
	
	@RequestMapping("/")
	public String home() {
		return "admin";
	}
	
	@RequestMapping("/products")
	public String products() {
		return "admin/products";
	}
	
	@RequestMapping("/products/addProduct")
	public String addProduct(Model model) {
		List<ProductCategory> categories = categoryRepo.findAll();
		model.addAttribute(categories);
		System.out.println(categories);
		return "admin/addProductForm";
	}
}
