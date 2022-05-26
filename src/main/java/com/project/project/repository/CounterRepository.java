package com.project.project.repository;

import com.project.project.classes.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends MongoRepository<Counter, String> {
  Counter findByLocate(String locate);

  Counter findByCount(long count);
}
