package com.profesorp.cascade.repositories;


import com.profesorp.cascade.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}