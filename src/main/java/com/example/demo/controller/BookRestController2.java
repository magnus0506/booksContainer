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
public class BookRestController2 {
    private BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookRestController2(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @GetMapping("/publishers")
    public List<Publisher> findAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book realbook = book.get();
            return new ResponseEntity<>(realbook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newbook", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        System.out.println(book);
        return bookRepository.save(book);
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<Publisher> findPublisherById(@PathVariable Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if (publisher.isPresent()) {
            Publisher realpublisher = publisher.get();
            return new ResponseEntity<>(realpublisher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newpub", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher postPublisher(@RequestBody Publisher publisher) {
        System.out.println(publisher);
        return publisherRepository.save(publisher);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authors = authorRepository.findAll();
        return authors;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            Author realauthor = author.get();
            return new ResponseEntity<>(realauthor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/newauthor", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Author postAuthor(@RequestBody Author author) {
        System.out.println(author);
        return authorRepository.save(author);
    }


}
