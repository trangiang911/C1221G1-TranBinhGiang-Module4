package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerRestController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping(value = "/list-customer")
    public ResponseEntity<Page<Customer>> getListCustomer(Model model,
                                                          @RequestParam Optional<String> sort,
                                                          @RequestParam Optional<String> name,
                                                          @RequestParam Optional<String> address,
                                                          @RequestParam Optional<String> type,
                                                          @PageableDefault(value = 50,sort = {})Pageable pageable){
        Page<Customer> customers = this.iCustomerService.findAllCustomer(pageable);
        if(!customers.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @PostMapping(value = "/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
