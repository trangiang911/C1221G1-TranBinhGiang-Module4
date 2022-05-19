package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("rest-cate")
public class CateRestController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping(value = "/list-cate")
    public ResponseEntity<Page<Category>> getPageCate(@RequestParam Optional<String> sort,
                                                      @PageableDefault(value = 5, sort = {}) Pageable pageable) {
        String sortBy = sort.orElse("");
        Page<Category> categoryPage = this.iCategoryService.findAllPage(pageable);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
}
