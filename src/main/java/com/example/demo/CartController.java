package com.example.demo;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/addToCart/{pid}")
	public String addToCArt(@PathVariable long pid, HttpSession session, Model model) {
		ArrayList<Long> productsInCart = (ArrayList<Long>) session.getAttribute("productsInCart");
		if(productsInCart==null) {
			productsInCart = new ArrayList<Long>();
		}
		productsInCart.add(pid);
		session.setAttribute("productsInCart", productsInCart);
		model.addAttribute("productsInCart", productsInCart);
		return "redirect:/";
	}
}
