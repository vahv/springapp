package com.helloworld.springapp.repositories;

import com.helloworld.springapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
