package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService iProductService;

//    @RequestMapping(value = {"","/home"}, method = RequestMethod.GET)
    @GetMapping(value = {"","/home"})
    public String home(Model model) {
        model.addAttribute("products", this.iProductService.findAll());
        return "home";
    }
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
//    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @PostMapping(value = "/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/";
    }
//    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @PostMapping(value = "/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess","Xoá thành công");
        return "redirect:/";
    }
//    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String goEdit(@RequestParam Integer id,Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        return "edit";
    }
//    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        this.iProductService.update(product.getId(),product);
        redirectAttributes.addAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/";
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @GetMapping(value = "/search")
    public String search(@RequestParam String name,Model model){
        model.addAttribute("products",this.iProductService.search(name));
        return "home";
    }
}
