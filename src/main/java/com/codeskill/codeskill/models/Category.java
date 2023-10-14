package com.codeskill.codeskill.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "categories")
public class Category {
    @Id
    private long id;
    private String name;

    @DBRef
    private List<Test> tests;

    public List<Test> getTests(){
        return tests;
    }
}
