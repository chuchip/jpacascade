package com.profesorp.cascade.controllers.dtos;

import com.profesorp.cascade.entities.LineaFra;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LineaOutputDto {

    int id;
    String producto;
    double cantidad;
    double importe;


    public LineaOutputDto(LineaFra lineaFra)
    {
        id=lineaFra.getId();
        producto=lineaFra.getProducto();
        cantidad=lineaFra.getCantidad();
        importe=lineaFra.getImporte();
    }
}
