package com.codeskill.codeskill.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
public class Question {
    @Id
    private long id;
    private long name;
    private String questionText;

    @DBRef
    private List<Answer> answers;

    @DBRef
    private List<Category> categories;

    public void setCategories(List<ObjectId> categoryId){
        this.categories = categories;
    }
}
