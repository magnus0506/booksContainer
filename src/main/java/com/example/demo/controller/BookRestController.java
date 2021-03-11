package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookRestController(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/booksvvvv")
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        books = bookRepository.findAll();
        return books;
    }

    @GetMapping("/publishersxxx")
    public List<Publisher> findAllPublisers() {
        List<Publisher> publishers = new ArrayList<>();
        publishers = publisherRepository.findAll();
        return publishers;
    }


}

