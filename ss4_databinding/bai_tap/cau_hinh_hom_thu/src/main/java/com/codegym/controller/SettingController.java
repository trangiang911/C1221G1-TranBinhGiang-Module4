package com.codegym.controller;

import com.codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class SettingController {

    @RequestMapping(value = "/setting",method = RequestMethod.GET)
    public String goSetting(Model model){
        model.addAttribute("setting",new Setting());
        return "from";
    }
    @RequestMapping(value = "/setting",method = RequestMethod.POST)
    public String setting(@ModelAttribute Setting setting,Model model){
            model.addAttribute("setting",setting);
        return "display";
    }
}
