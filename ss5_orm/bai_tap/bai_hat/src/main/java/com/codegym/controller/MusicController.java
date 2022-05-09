package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.services.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/music")
public class MusicController {
@Autowired
    IMusicService iMusicService;
    @GetMapping(value = "")
    public String show(Model model){
        model.addAttribute("musics",this.iMusicService.FindAll());
        return "list";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/music/";
    }
    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam Integer id,Model model){
        model.addAttribute("music",this.iMusicService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Music music,RedirectAttributes redirectAttributes) {
        this.iMusicService.update(music);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/music/";
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        Music music=this.iMusicService.findById(id);
        this.iMusicService.delete(music);
        redirectAttributes.addFlashAttribute("mess","Xoá thành công");
        return "redirect:/music/";
    }
}
