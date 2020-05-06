package com.github.valchevgd.spring5webapp.repositories;

import com.github.valchevgd.spring5webapp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
