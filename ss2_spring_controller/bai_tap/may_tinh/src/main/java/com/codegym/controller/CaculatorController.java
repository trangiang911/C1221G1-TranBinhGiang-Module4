package com.codegym.controller;

import com.codegym.services.ICalculatorService;
import com.codegym.services.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CaculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view() {
        return "home";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calculator(
            @RequestParam("number1") String number1, @RequestParam("number2") String number2, @RequestParam("op") char op, Model model) {
        String result=this.iCalculatorService.calculator(number1,number2,op);
        model.addAttribute("result",result);
        return "home";
    }
}
