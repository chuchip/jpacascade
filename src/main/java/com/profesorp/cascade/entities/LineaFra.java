package com.profesorp.cascade.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class LineaFra  {
    public LineaFra(String producto, double cantidad, double importe) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    @Id
    @GeneratedValue
    int id;

    @ManyToOne( cascade = CascadeType.PERSIST)
    CabeceraFra cabeceraFra;

    String producto;
    double cantidad;
    double importe;


}
