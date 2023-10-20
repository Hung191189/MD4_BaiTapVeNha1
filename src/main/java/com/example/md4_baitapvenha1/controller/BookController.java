package com.example.md4_baitapvenha1.controller;

import com.example.md4_baitapvenha1.model.Book;
import com.example.md4_baitapvenha1.model.Category;
import com.example.md4_baitapvenha1.service.IBookService;
import com.example.md4_baitapvenha1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    HttpSession httpSession;

    @GetMapping("")
        public ModelAndView showHome(@CookieValue(value = "counters", defaultValue = "1") Long counter, HttpServletResponse response) {
        counter++;
        Cookie cookie = new Cookie("counters", counter.toString());
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("/home");
        System.out.println(cookie);
        modelAndView.addObject("cookie", cookie.getValue());
        modelAndView.addObject("cookie1", cookie);
        modelAndView.addObject("book", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/book/create");
    }

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @PostMapping("/create")
    public ModelAndView save(Book book) {
//    Optional<Category> optionalCategory = categoryService.findById(idCategory);
//    book.setCategory(optionalCategory.get());
        bookService.save(book);
        httpSession.setAttribute("book", book);
        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        bookService.remove(id);
        return new ModelAndView("redirect:/books");
    }
    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id){
        return new ModelAndView("/book/update", "book", bookService.findById(id));
    }
    @PostMapping("/update")
    public ModelAndView saveUpdate(Book book){
        bookService.save(book);
        return new ModelAndView("redirect:/books");
    }
@GetMapping("/viewSession")
    public ModelAndView viewSession(){
        Book book = (Book) httpSession.getAttribute("book");
        return new ModelAndView("/info", "book", book);
}
}
