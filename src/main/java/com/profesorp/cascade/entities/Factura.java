package com.profesorp.cascade.entities;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.MappedSuperclass;
@Getter
@Setter
@MappedSuperclass
public class Factura {
    @Column(name="ejercicio")
    int ejercicio;
    @Column(name="numeroFra")
    int numeroFra;



}