package com.profesorp.cascade.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue
    int id;

    String nombre;
}
