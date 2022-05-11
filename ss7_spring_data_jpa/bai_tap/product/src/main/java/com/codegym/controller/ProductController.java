package com.codegym.controller;

import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 2,sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String nameVal = name .orElse("");
        String sortByname = sort.orElse("");
        model.addAttribute("sort",sortByname);
        model.addAttribute("categories",this.iCategoryService.findAll());
        model.addAttribute("products", this.iProductService.findAndSearch(nameVal,pageable));
        model.addAttribute("search",nameVal);
        return "list";
    }
}
