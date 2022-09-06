package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelComtroller {
	@RequestMapping("/")
	public String home() {
		return "admin";
	}
	
	@RequestMapping("/products")
	public String products() {
		return "admin/products";
	}
	
	@RequestMapping("/products/addProduct")
	public String addProduct() {
		return "admin/addProductForm";
	}
}
