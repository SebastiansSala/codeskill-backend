package com.codeskill.codeskill.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "answers")
public class Answer {
    @Id
    private long id;
    private String answerText;
    private boolean isCorrect;
}
