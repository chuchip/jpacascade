package com.profesorp.cascade.repositories;


import com.profesorp.cascade.entities.PriceArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceArticleRepository extends JpaRepository<PriceArticle, Integer> {
}