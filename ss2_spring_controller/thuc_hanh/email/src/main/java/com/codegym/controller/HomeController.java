package com.codegym.controller;

import com.codegym.services.IValidateService;
import com.codegym.services.impl.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    IValidateService iValidateService=new ValidateService();


    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public String user(@RequestParam("email") String email, ModelMap modelMap){
        boolean isValid= iValidateService.validate(email);
        if(!isValid){
            modelMap.addAttribute("mess","Email is invalid");
            return "home";
        }else {
            modelMap.addAttribute("mess",email+" is success");
            return "home";
        }
    }
}
