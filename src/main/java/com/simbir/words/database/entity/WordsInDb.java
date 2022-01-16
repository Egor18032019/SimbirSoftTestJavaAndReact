package com.simbir.words.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TreeMap;
// название БД
@Document("groceryitems")
public class WordsInDb {

    @Id
    private String id;

    private TreeMap<String, Integer> words ;


    public WordsInDb( TreeMap<String, Integer> words) {
        super();

        this.words = words;

    }
}