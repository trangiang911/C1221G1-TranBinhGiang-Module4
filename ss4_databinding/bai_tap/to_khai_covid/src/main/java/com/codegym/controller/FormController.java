package com.codegym.controller;

import com.codegym.model.Form;
import com.codegym.services.IFormSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class FormController {

    @Autowired
    IFormSerive iFormSerive;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("form", new Form());
        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Form form, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("form",iFormSerive.save(form));
        return "redirect:display";
    }
}
