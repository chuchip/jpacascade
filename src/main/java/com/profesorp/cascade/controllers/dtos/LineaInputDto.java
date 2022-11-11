package com.profesorp.cascade.controllers.dtos;

import com.profesorp.cascade.entities.LineaFra;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class LineaInputDto {

    String producto;
    double cantidad;
    double importe;
    int idFra;

    public LineaFra toEntity()
    {
        LineaFra l=new LineaFra();
        l.setProducto(producto);
        l.setCantidad(cantidad);
        l.setImporte(importe);
        return l;
    }
}
