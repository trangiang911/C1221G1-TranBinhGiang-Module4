package com.codegym.controller;

import com.codegym.Dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showCart(@SessionAttribute(name = "cart",required = false)CartDto cart, Model model){
        model.addAttribute("carts",cart);
        return "cart";
    }
}
