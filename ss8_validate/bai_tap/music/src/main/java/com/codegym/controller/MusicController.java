package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping (value = "")
    public String goList(Model model,
                         @RequestParam Optional<String> sort,
                         @PageableDefault(value = 2,sort = {})Pageable pageable,
                         @RequestParam Optional<String> name){
        String nameVal=name.orElse("");
        String sortBy=sort.orElse("");
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("sort",sortBy);
        model.addAttribute("musics",this.iMusicService.findAndSearch(nameVal,pageable));
        return "list";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("musicDto",new MusicDto());
        return "create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
//        new MusicDto().validate()
        if(bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Music music=new Music();
            BeanUtils.copyProperties(musicDto,music);
            redirectAttributes.addFlashAttribute("mess","OK!");
            return "redirect:/music/";
        }
    }
}
