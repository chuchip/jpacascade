package com.profesorp.cascade.repositories;

import com.profesorp.cascade.entities.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
}