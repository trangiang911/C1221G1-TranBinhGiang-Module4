package com.codegym.controller;

import com.codegym.Dto.CartDto;
import com.codegym.Dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@SessionAttributes("cart")
@Controller
@RequestMapping("/product")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "")
    public String goList(Model model,
                         @RequestParam Optional<String> sort,
                         @PageableDefault(value = 6,sort = {})Pageable pageable,
                         @RequestParam Optional<String> name){
        String nameVal=name.orElse("");
        String sortBy=sort.orElse("");
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("sort",sortBy);
        model.addAttribute("products",this.iProductService.findAndSearch(nameVal,pageable));
        return "list";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("cart") CartDto cart){
        Optional<Product> productOptional=this.iProductService.findById(id);
        if(productOptional.isPresent()){
            ProductDto productDto=new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
