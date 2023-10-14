package com.codeskill.codeskill.repositories;

import com.codeskill.codeskill.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String>{
}
