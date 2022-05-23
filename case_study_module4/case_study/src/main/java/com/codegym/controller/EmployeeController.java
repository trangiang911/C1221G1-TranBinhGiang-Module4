package com.codegym.controller;

import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;

    @GetMapping("")
    public String goList(Model model,
                         @RequestParam Optional<String> sort,
                         @RequestParam Optional<String> name,
                         @RequestParam Optional<String> address,
                         @RequestParam Optional<String> position,
                         @PageableDefault(value = 5, sort = {}) Pageable pageable) {
        String nameVal = name.orElse("");
        String sortBy = sort.orElse("");
        String addressBy = address.orElse("");
        String positionBy = position.orElse("%");
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("address", addressBy);
        model.addAttribute("position", positionBy);
        model.addAttribute("sort", sortBy);
        model.addAttribute("employees", this.iEmployeeService.findAndSearch(nameVal, addressBy, positionBy, pageable));
        model.addAttribute("positions", this.iPositionService.findAll());
        return "employee/list-employee";
    }
}
