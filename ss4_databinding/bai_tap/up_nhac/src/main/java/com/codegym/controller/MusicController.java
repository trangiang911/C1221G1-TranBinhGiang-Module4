package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import com.codegym.service.impl.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class MusicController {
    @Autowired
    IMusicService iMusicService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("music1",this.iMusicService.findAll());
        return "home";
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String goCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@ModelAttribute Music music, Model model, RedirectAttributes redirectAttributes){
        this.iMusicService.save(music);
//        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/";
    }
}
