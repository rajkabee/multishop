package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Product;
import com.example.demo.model.repos.ProductRepository;

@Controller
public class ViewController {
	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping("/")
	public String index(Model model) {
		Pageable page = PageRequest.of(0, 8);
		List<Product> products = productRepo.findByCategoryId(1, page);
		model.addAttribute("products", products);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/productByCategory/{id}")
	public List<Product> getProductByCategory(@PathVariable("id") long id){
		Pageable page = PageRequest.of(0, 8);
		return productRepo.findByCategoryId(id, page);
	}
	
}
