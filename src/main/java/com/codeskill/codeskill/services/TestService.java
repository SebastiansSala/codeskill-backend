package com.codeskill.codeskill.services;

import com.codeskill.codeskill.models.Test;
import com.codeskill.codeskill.repositories.TestRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test createTest(Test test){
        return testRepository.save(test);
    }

    public Optional<Test> getTestById(String id){
        return testRepository.findById(id);
    }

    public void deleteTestById(String id){
        testRepository.deleteById(id);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
    public List<Test> getTestsByCategoryIds(List<String> categoryIds){
        return testRepository.findAllById(categoryIds);
    }
}
