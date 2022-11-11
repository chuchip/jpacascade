package com.profesorp.cascade.repositories;

import com.profesorp.cascade.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
