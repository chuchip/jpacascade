package com.profesorp.cascade.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class CabeceraFra extends Factura{
    @Id
    @GeneratedValue
    int id;

    double importeFra=0;

    @OneToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    List<LineaFra> lineasFra;

    @ManyToOne
    Cliente cliente;

    public void addLinea(LineaFra lineaFra)
    {
        if (lineasFra==null)
            lineasFra=new ArrayList<LineaFra>();
        lineaFra.setCabeceraFra(this);
        lineasFra.add(lineaFra);
    }
}