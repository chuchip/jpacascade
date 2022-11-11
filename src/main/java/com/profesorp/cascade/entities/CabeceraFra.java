package com.profesorp.cascade.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    public void addLinea(LineaFra lineaFra)
    {
        if (lineasFra==null)
            lineasFra=new ArrayList();
        lineaFra.setCabeceraFra(this);
        lineasFra.add(lineaFra);
    }
}