package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping(value = {"","/home"})
    public String list(Model model,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2,sort = {})Pageable pageable,
                       @RequestParam Optional<String> name){
        String nameVal=name.orElse("");
        String sortBy=sort.orElse("");
        model.addAttribute("sort",sortBy);
        model.addAttribute("blogs",this.iBlogService.findByname(nameVal,pageable));
        model.addAttribute("nameVal",nameVal);
        return "home";
    }
    @GetMapping(value = "/detail")
    public String goDetail(Model model, @RequestParam Integer id){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "detail";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",this.iCategoryService.findAll());
        return "create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/blog/";
    }
    @GetMapping(value = "/edit")
    public String goEdit(Model model,@RequestParam Integer id){
        model.addAttribute("blog",this.iBlogService.findById(id));
        model.addAttribute("categorys",this.iCategoryService.findAll());
        return "edit";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        this.iBlogService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","xoá thành công");
        return "redirect:/blog/";
    }
}
