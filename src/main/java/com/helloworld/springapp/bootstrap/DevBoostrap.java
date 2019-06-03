package com.helloworld.springapp.bootstrap;

import com.helloworld.springapp.model.Author;
import com.helloworld.springapp.model.Book;
import com.helloworld.springapp.repositories.AuthorRepository;
import com.helloworld.springapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DevBoostrap implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public DevBoostrap(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Desing", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "5678", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
