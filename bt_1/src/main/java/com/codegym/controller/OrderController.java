package com.codegym.controller;

import com.codegym.dto.OrderProductDto;
import com.codegym.models.OrderProduct;
import com.codegym.services.IOrderProductService;
import com.codegym.services.IProductService;
import com.codegym.services.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
                       @PageableDefault(value = 5,sort={})Pageable pageable,
                       @RequestParam Optional<String> dateStart,
                       @RequestParam Optional<String> dateEnd,
                       @RequestParam Optional<String> top){
        String topBy=top.orElse("");
        String dateStartBy=dateStart.orElse("");
        String dateEndBy=dateEnd.orElse("");
        if(topBy.equals("")){
            model.addAttribute("dateStart",dateStartBy);
            model.addAttribute("dateEnd",dateEndBy);
            model.addAttribute("orders",this.iOrderProductService.findAndSearch(dateStartBy,dateEndBy,pageable));
        }else{
            pageable=PageRequest.of(0,Integer.parseInt(topBy));
            model.addAttribute("orders",this.iOrderProductService.findTop(pageable));
        }
        return "list";
    }
    @GetMapping("/edit")
    public String goEdit(Model model,
                       @RequestParam("id") Integer id){
        OrderProduct orderProduct= (OrderProduct) this.iOrderProductService.findById(id);
        OrderProductDto orderProductDto=new OrderProductDto();
        BeanUtils.copyProperties(orderProduct,orderProductDto);
        model.addAttribute("orderProductDto",orderProductDto);
        model.addAttribute("types",this.iProductTypeService.findAll());
        model.addAttribute("products",this.iProductService.findAll());
        return "edit";
    }
}
