package com.helloworld.springapp.repositories;

import com.helloworld.springapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
