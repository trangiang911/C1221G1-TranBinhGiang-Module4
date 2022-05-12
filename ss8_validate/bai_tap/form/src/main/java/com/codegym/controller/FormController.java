package com.codegym.controller;

import com.codegym.dto.FormDto;
import com.codegym.model.Form;
import com.codegym.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {
@Autowired
    IFormService iFormService;
    @GetMapping(value = "")
    public String goCreate(Model model){
        model.addAttribute("formDto",new FormDto());
        return "create";
    }
    @PostMapping(value = "")
    public String create(@ModelAttribute @Validated FormDto formDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        new FormDto().validate(formDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Form form=new Form();
            BeanUtils.copyProperties(formDto,form);
            this.iFormService.save(form);
            redirectAttributes.addFlashAttribute("mess","OK!");
            return "redirect:/form/";
        }

    }
}
