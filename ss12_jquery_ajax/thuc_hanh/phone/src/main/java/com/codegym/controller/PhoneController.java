package com.codegym.controller;

import com.codegym.Dto.PhoneDto;
import com.codegym.model.Phone;
import com.codegym.service.IPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    IPhoneService iPhoneService;

    @GetMapping("")
    public ResponseEntity<Page<Phone>> goList(@RequestParam Optional<String> sort,
                                              @PageableDefault(value = 2, sort = {}) Pageable pageable,
                                              @RequestParam Optional<String> model) {
        String modelVal = model.orElse("");
        String sortBy = sort.orElse("");
        Page<Phone> phonePage = this.iPhoneService.findByName(modelVal, pageable);
        if (!phonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phonePage,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> create(@RequestBody @Validated PhoneDto phoneDto,
                                                   BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        Phone phone=new Phone();
        BeanUtils.copyProperties(phoneDto,phone);
        this.iPhoneService.save(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deleteSmartphone(@PathVariable Long id) {
        Optional<Phone> smartphoneOptional = this.iPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
