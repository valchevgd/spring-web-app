package com.github.valchevgd.spring5webapp.bootstrap;

import com.github.valchevgd.spring5webapp.models.Author;
import com.github.valchevgd.spring5webapp.models.Book;
import com.github.valchevgd.spring5webapp.models.Publisher;
import com.github.valchevgd.spring5webapp.repositories.AuthorRepository;
import com.github.valchevgd.spring5webapp.repositories.BookRepository;
import com.github.valchevgd.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author evens = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "123456");

        evens.getBooks().add(ddd);
        ddd.getAuthors().add(evens);

        Publisher publisher = new Publisher("Helikon",
                "Sofia",
                "Sofia",
                "Samboliyski 25",
                "2900");
        publisherRepository.save(publisher);

        publisher.getBooks().add(ddd);
        ddd.setPublisher(publisher);

        authorRepository.save(evens);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        Author johnson = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123123");

        johnson.getBooks().add(noEJB);
        noEJB.getAuthors().add(johnson);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(johnson);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());

        System.out.println("Count of publishers: " + publisherRepository.count());
        System.out.println("Count of publisher's books: " + publisher.getBooks().size());
    }
}
