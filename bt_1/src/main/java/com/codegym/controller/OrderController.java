package com.codegym.controller;

import com.codegym.models.OrderProduct;
import com.codegym.services.IOrderProductService;
import com.codegym.services.IProductService;
import com.codegym.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderProductService iOrderProductService;
    @Autowired
    IProductService iProductService;
    @Autowired
    IProductTypeService iProductTypeService;
    @GetMapping("")
    public String list(Model model,
                       @PageableDefault(value = 1,sort={})Pageable pageable,
                       @RequestParam Optional<String> dateStart,
                       @RequestParam Optional<String> dateEnd){
        String dateStartBy=dateStart.orElse("0001-01-01");
        String dateEndBy=dateEnd.orElse("9999-12-31");
        model.addAttribute("dateStart",dateStartBy);
        model.addAttribute("dateEnd",dateEndBy);
        model.addAttribute("orders",this.iOrderProductService.findAndSearch(dateStartBy,dateEndBy,pageable));
        return "list";
    }

}
