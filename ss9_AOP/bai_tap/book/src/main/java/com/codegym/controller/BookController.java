package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Code;
import com.codegym.service.ICodeBookService;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    ILibraryService iLibraryService;
    @Autowired
    ICodeBookService iCodeBookService;

    @GetMapping(value = "")
    public String list(Model model,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        String sortBy = sort.orElse("");
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("sort", sortBy);
        model.addAttribute("books", this.iLibraryService.findAndSearch(nameVal, pageable));
        return "list";
    }

    @GetMapping(value = "/detail")
    public String goDetail(Model model, @RequestParam Integer id) {
        model.addAttribute("librarys", this.iLibraryService.findById(id));
        return "detail";
    }

    @PostMapping(value = "/borrow")
    public String borrow(RedirectAttributes redirectAttributes, Model model, @ModelAttribute Book librarys) {
        if (this.iLibraryService.borrow(librarys) == null) {
            model.addAttribute("code", this.iCodeBookService.getCodeBook(librarys));
            model.addAttribute("librarys", librarys);
            model.addAttribute("mess", "Mượn thành công");
            return "detail";
        }else {
            model.addAttribute("librarys", librarys);
            model.addAttribute("mess",this.iLibraryService.borrow(librarys));
            return "detail";
        }
    }

    @GetMapping(value = "/return")
    public String returnBook(@RequestParam String code, RedirectAttributes redirectAttributes, Model model) {
        Code codeObj = this.iCodeBookService.findByCode(code);
        Book book = this.iLibraryService.findById(codeObj.getBook().getId());
        this.iLibraryService.plusAmount(book);
        this.iCodeBookService.remove(codeObj);
        redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/book/";
    }
    @ExceptionHandler(NullPointerException.class)
    public String showError(){
        return "error";
    }
}
