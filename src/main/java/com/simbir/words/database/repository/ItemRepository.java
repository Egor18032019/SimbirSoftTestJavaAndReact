package com.simbir.words.database.repository;

import com.simbir.words.database.entity.WordsInDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<WordsInDb, String> {


 }