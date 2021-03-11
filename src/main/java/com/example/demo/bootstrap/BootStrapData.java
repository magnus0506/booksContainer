package com.example.demo.bootstrap;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// fjern lige flere bøger Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setAddressLine1("Vestergade 2");
        publisher.setName("Danish Publishing");
        publisher.setCity("Copenhagen");
        publisher.setCountry("Denmark");

        publisherRepository.save(publisher);

        Author jens = new Author("Jens", "Larsen");
        Book mermaid = new Book("Little Mermaid", "33242342");
        jens.getBooks().add(mermaid);
        mermaid.getAuthors().add(jens);
        mermaid.setPublisher(publisher);
        publisher.getBooks().add(mermaid);

        authorRepository.save(jens);
        bookRepository.save(mermaid);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "332432432");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}

