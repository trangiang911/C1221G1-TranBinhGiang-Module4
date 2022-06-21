package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class OrderRestController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/list-product")
    public ResponseEntity<List<Product>> getListProduct(Model model,
                                                        @RequestParam("id") Integer id) {
        List<Product> productList = this.iProductService.findAllById(id);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
