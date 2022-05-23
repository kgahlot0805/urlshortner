package com.project.project.repository;

import com.project.project.classes.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url,String> {
    Url findByUrlString(String urlString);
    Url findById(long id);
}
