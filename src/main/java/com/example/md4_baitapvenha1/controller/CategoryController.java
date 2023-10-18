package com.example.md4_baitapvenha1.controller;

import com.example.md4_baitapvenha1.model.Category;
import com.example.md4_baitapvenha1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public ModelAndView showListCategory(){
        return new ModelAndView("/category/listCategory", "category", categoryService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/category/create");
    }
    @PostMapping("/create")
    public ModelAndView save(Category category){
        categoryService.save(category);
        return new ModelAndView("redirect:/category");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        categoryService.remove(id);
        return new ModelAndView("redirect:/category");
    }
    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id){
        return new ModelAndView("/category/update", "category", categoryService.findById(id));
    }
    @PostMapping("/update")
    public ModelAndView saveUpdate(Category category){
        categoryService.save(category);
        return new ModelAndView("redirect:/category");
    }
}
