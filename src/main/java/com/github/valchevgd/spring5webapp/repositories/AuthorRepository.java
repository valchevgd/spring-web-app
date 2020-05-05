package com.github.valchevgd.spring5webapp.repositories;

import com.github.valchevgd.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
