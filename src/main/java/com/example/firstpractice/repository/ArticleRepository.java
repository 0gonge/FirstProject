package com.example.firstpractice.repository;

import com.example.firstpractice.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
