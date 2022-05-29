package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.CustomerHaveBooking;
import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @GetMapping("")
    public String goList(Model model,
                         @RequestParam Optional<String> sort,
                         @RequestParam Optional<String> name,
                         @RequestParam Optional<String> address,
                         @RequestParam Optional<String> type,
                         @PageableDefault(value = 5,sort = {})Pageable pageable){
        String nameVal=name.orElse("");
        String sortBy=sort.orElse("");
        String addressBy=address.orElse("");
        String typeBy=type.orElse("%");
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("address",addressBy);
        model.addAttribute("type",typeBy);
        model.addAttribute("sort",sortBy);
        model.addAttribute("customers",this.iCustomerService.findAndSearch(nameVal,addressBy,typeBy,pageable));
        model.addAttribute("customerTypes",this.iCustomerTypeService.findAll());
        return "customer/list-customers";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("customerTypes",this.iCustomerTypeService.findAll());
        return "customer/create-customers";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        customerDto.setCustomers(this.iCustomerService.findAll());
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypes",this.iCustomerTypeService.findAll());
            return "customer/create-customers";
        }else {
            Customer customer=new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess","OK!");
            return "redirect:/customer/";
        }
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam Integer id,
                         RedirectAttributes redirectAttributes){
        this.iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete Ok!");
        return "redirect:/customer/";
    }
    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam Integer id,
                       RedirectAttributes redirectAttributes,
                       Model model){
        Customer customer= (Customer) this.iCustomerService.findById(id);
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        model.addAttribute("customerTypes",this.iCustomerTypeService.findAll());
        return "customer/edit-customers";
    }
    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute CustomerDto customerDto,
                       RedirectAttributes redirectAttributes){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Edit OK!");
        return "redirect:/customer/";
    }
    @GetMapping("/have-booking")
    public String getCustomerHaveBooking(Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<CustomerHaveBooking> customerHaveBookings = this.iCustomerService.findAllCustomerHaveBooking(pageable);
        model.addAttribute("customerHaveBookings", customerHaveBookings);
        return "/customer/booking";
    }
}
