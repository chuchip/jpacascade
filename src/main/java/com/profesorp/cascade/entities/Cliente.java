package com.profesorp.cascade.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue
    int id;

    String nombre;
}
