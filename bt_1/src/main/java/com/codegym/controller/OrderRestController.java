package com.codegym.controller;

import com.codegym.models.Product;
import com.codegym.services.IProductService;
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
                                                        @RequestParam("id") Integer id){
        List<Product> productList=this.iProductService.findAllById(id);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
