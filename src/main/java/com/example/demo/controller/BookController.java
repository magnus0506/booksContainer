package com.example.demo.controller;

import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/xzbooks")
    public String getBooksz(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        var bb = bookRepository.findAll();
        //bb.forEach(book -> System.out.println(book.getTitle()));
        bb.forEach(book -> System.out.println("book= " + book.getPublisher().getName()));
        System.out.println("done books");
        return "books/list";
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
