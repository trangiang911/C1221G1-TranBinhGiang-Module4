package com.codegym.controller;

import com.codegym.dto.BenXeDto;
import com.codegym.model.BenXe;
import com.codegym.service.IBenXeService;
import com.codegym.service.ILoaiXeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/ben-xe")
public class BenXeController {
    @Autowired
    IBenXeService iBenXeService;
    @GetMapping(value = "/list")
    public ResponseEntity<Page<BenXe>> getAllBenXe(ModelMap modelMap,
                                                   @RequestParam Optional<String> criterion,
                                                   @RequestParam Optional<String> valueSearch,
                                                   @RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "5") Integer size
                                                   ) {
        Pageable pageable = PageRequest.of(page,size);
        String criterionVal = criterion.orElse("%");
        String valueSearchVal = valueSearch.orElse("");
        System.out.println(criterionVal);
        System.out.println(valueSearchVal);

        Page benXes;
        List<BenXe> benXeList=  this.iBenXeService.findAndSearch(criterionVal, valueSearchVal);
        int start = Math.min((int)pageable.getOffset(), benXeList.size());
        int end = Math.min((start + pageable.getPageSize()), benXeList.size());
        if(benXeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        benXes = new PageImpl(benXeList.subList(start,end), pageable, benXeList.size());
        return new ResponseEntity<>(benXes, HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<BenXe> createBenXe(@Valid @RequestBody BenXeDto benXeDto,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BenXe benXe = new BenXe();
        BeanUtils.copyProperties(benXeDto,benXe);
        this.iBenXeService.createBenXe(benXe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<BenXe> findBenXeById(@PathVariable Integer id){
        BenXe benXe = this.iBenXeService.findBenXeById(id);
        if(benXe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(benXe,HttpStatus.OK);
    }
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<BenXe> updateBenXe(@PathVariable Integer id,
                                             @Valid @RequestBody BenXeDto benXeDto,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BenXe benXe = new BenXe();
        BeanUtils.copyProperties(benXeDto,benXe);
        this.iBenXeService.createBenXe(benXe);
        return new ResponseEntity<>(benXe,HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BenXe> deleteBenXe(@PathVariable Integer id){
        BenXe benXe = this.iBenXeService.findBenXeById(id);
        if(benXe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iBenXeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
