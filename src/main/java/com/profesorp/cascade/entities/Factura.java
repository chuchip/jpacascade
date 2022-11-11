package com.profesorp.cascade.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import javax.persistence.MappedSuperclass;
@Getter
@Setter
@MappedSuperclass
public class Factura {
    @Column(name="ejercicio")
    int ejercicio;
    @Column(name="numeroFra")
    int numeroFra;



}