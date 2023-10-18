package com.example.md4_baitapvenha1.controller;

import com.example.md4_baitapvenha1.model.Book;
import com.example.md4_baitapvenha1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService bookService;
@GetMapping("")
    public ModelAndView showHome(){
    return new ModelAndView("/home","book", bookService.findAll());
}
@GetMapping("/create")
    public ModelAndView showCreateForm(){
    return new ModelAndView("/book/create");
}
@PostMapping("/create")
    public ModelAndView save(Book book){
    bookService.save(book);
    return new ModelAndView("redirect:/books");
}
}
