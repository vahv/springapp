package com.helloworld.springapp.bootstrap;

import com.helloworld.springapp.model.Author;
import com.helloworld.springapp.model.Book;
import com.helloworld.springapp.model.Publisher;
import com.helloworld.springapp.repositories.AuthorRepository;
import com.helloworld.springapp.repositories.BookRepository;
import com.helloworld.springapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private  PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher collins = new Publisher("Harper Collins","143 Queen Av");
        Book ddd = new Book("Domain Driven Desing", "1234", collins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(collins);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "1337 Street");
        Book noEJB = new Book("J2EE Development without EJB", "5678", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
