package com.codegym.controller;

import com.codegym.dto.OrderProductDto;
import com.codegym.model.OrderProduct;
import com.codegym.service.IOrderProductService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                       @PageableDefault(value = 5, sort = {}) Pageable pageable,
                       @RequestParam Optional<String> dateStart,
                       @RequestParam Optional<String> dateEnd,
                       @RequestParam Optional<String> top) {
        String topBy = top.orElse("");
        String dateStartBy = dateStart.orElse("");
        String dateEndBy = dateEnd.orElse("");
        if (topBy.equals("")) {
            model.addAttribute("top", topBy);
            model.addAttribute("dateStart", dateStartBy);
            model.addAttribute("dateEnd", dateEndBy);
            model.addAttribute("orders", this.iOrderProductService.findAndSearch(dateStartBy, dateEndBy, pageable));
        } else {
            pageable = PageRequest.of(0, Integer.parseInt(topBy));
            model.addAttribute("orders", this.iOrderProductService.findTop(pageable));
        }
        return "list";
    }

    @GetMapping("/edit")
    public String goEdit(Model model,
                         @RequestParam("id") Integer id) {
        OrderProduct orderProduct = (OrderProduct) this.iOrderProductService.findById(id);
        OrderProductDto orderProductDto = new OrderProductDto();
        BeanUtils.copyProperties(orderProduct, orderProductDto);
        model.addAttribute("orderProductDto", orderProductDto);
        model.addAttribute("types", this.iProductTypeService.findAll());
        model.addAttribute("products", this.iProductService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated OrderProductDto orderProductDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new OrderProductDto().validate(orderProductDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("types", this.iProductTypeService.findAll());
            model.addAttribute("products", this.iProductService.findAll());
            return "edit";
        } else {
            OrderProduct orderProduct = new OrderProduct();
            BeanUtils.copyProperties(orderProductDto, orderProduct);
            this.iOrderProductService.save(orderProduct);
            redirectAttributes.addFlashAttribute("mess", "Edit OK!");
            return "redirect:/order/";
        }

    }
}