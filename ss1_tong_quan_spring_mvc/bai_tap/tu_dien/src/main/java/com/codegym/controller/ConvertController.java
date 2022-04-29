package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
    @PostMapping(value = "/home")
    public String convert(@RequestParam String x, Model model){
        model.addAttribute("result",this.iConvertService.convert(x));
        return "home";
    }
}
