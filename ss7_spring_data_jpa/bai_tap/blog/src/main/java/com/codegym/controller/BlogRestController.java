package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping(value = "/list-blog")
    public ResponseEntity<Page<Blog>> getPageBlog(@RequestParam Optional<String> sort,
                                                  @PageableDefault(value = 5, sort = {}) Pageable pageable,
                                                  @RequestParam Optional<String> name
    ) {
        String nameVal = name.orElse("");
        String sortBy = sort.orElse("");

        Page<Blog> blogPage = this.iBlogService.findByname(nameVal, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

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

    @GetMapping(value = "/list-blog-cate")
    public ResponseEntity<Page<Blog>> getBlogByCate(@RequestParam Optional<String> sort,
                                                    @PageableDefault(value = 5, sort = {}) Pageable pageable,
                                                    @RequestParam Optional<String> category) {
        String sortBy = sort.orElse("");
        String categoryBy = category.orElse("");
        Page<Blog> blogPage = this.iBlogService.findByCate(category, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping(value = "/detail")
    public ResponseEntity<Blog> getBlogById(@RequestParam Integer id) {
        Blog blog= this.iBlogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
