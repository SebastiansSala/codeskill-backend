package com.codeskill.codeskill.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tests")
public class Test {
    @Id
    private ObjectId id;
    private String name;
    private Question question;
    @DBRef
    private List<Question> questions;
    private List<String> categoryIds;

    public void setName(String name){
        this.name = name;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
