package com.helloworld.springapp.repositories;

        import com.helloworld.springapp.model.Author;
        import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
