package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationService iEducationService;
    @Autowired
    IDivisionService iDivisionService;

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

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positions", this.iPositionService.findAll());
        model.addAttribute("educations", this.iEducationService.findAll());
        model.addAttribute("divisions", this.iDivisionService.findAll());
        return "employee/employee-create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", this.iPositionService.findAll());
            model.addAttribute("educations", this.iEducationService.findAll());
            model.addAttribute("divisions", this.iDivisionService.findAll());
            return "employee/employee-create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", "OK!");
            return "redirect:/employee/";
        }

    }

    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam Integer id,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positions", this.iPositionService.findAll());
        model.addAttribute("educations", this.iEducationService.findAll());
        model.addAttribute("divisions", this.iDivisionService.findAll());
        return "employee/edit_employee";
    }

    @PostMapping(value = "/save")
    public String edit(@ModelAttribute @Validated EmployeeDto employeeDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", this.iPositionService.findAll());
            model.addAttribute("educations", this.iEducationService.findAll());
            model.addAttribute("divisions", this.iDivisionService.findAll());
            return "employee/employee-create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", "OK!");
            return "redirect:/employee/";
        }
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam Integer id,
                         RedirectAttributes redirectAttributes) {
        this.iEmployeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Ok!");
        return "redirect:/employee/";
    }
}
