package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.repository.ICategoryRepository;
import com.codegym.services.ICategoryService;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IProductService iProductService;
    @GetMapping(value = "")
    public String goList(Model model,
                         @RequestParam("name")Optional<String> name,
                         @RequestParam("price") Optional<String> price,
                         @RequestParam("category") Optional<String> category,
                         @RequestParam("sort")Optional<String> sort,
                         @PageableDefault(value = 2,sort = {})Pageable pageable){
        String nameVal=name.orElse("");
        String sortByName=sort.orElse("");
        String categoryFind=category.orElse("%");
        String priceFind=price.orElse("");
        model.addAttribute("category",categoryFind);
        model.addAttribute("price",priceFind);
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("sort",sortByName);
        model.addAttribute("products",this.iProductService.findAndSearch(nameVal,categoryFind,priceFind,pageable));
        model.addAttribute("categorys",this.iCategoryService.findAll());
        return "list";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("category",this.iCategoryService.findAll());
        return "create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","Th??m th??nh c??ng");
        return "redirect:/product/";
    }
    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam Integer id,RedirectAttributes redirectAttributes,Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        model.addAttribute("category",this.iCategoryService.findAll());
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","Ch???nh s???a th??nh c??ng");
        return "redirect:/product/";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Xo?? th??nh c??ng");
        return "redirect:/product/";
    }
}
