package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class SandWichController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view() {
        return "home";
    }

    @RequestMapping(value = "/sandwich", method = RequestMethod.POST)
    public String sandwich(@RequestParam(value = "condimet", defaultValue = "ko có gì") String[] condimet, Model model) {
        model.addAttribute("condimet", condimet);
        return "result";
    }
}
//optional<T> là một biến tuỳ chọn
