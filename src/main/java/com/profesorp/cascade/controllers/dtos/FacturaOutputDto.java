package com.profesorp.cascade.controllers.dtos;

import com.profesorp.cascade.entities.CabeceraFra;
import com.profesorp.cascade.entities.LineaFra;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class FacturaOutputDto {
    int id;

    double importeFra=0;
    ClienteOutputDto clienteOutputDto;
    List<LineaOutputDto> lineaOutputDtoList;
    public FacturaOutputDto(CabeceraFra cabeceraFra)
    {
       id=cabeceraFra.getId();
       importeFra=cabeceraFra.getImporteFra();
       List<LineaFra> lista=cabeceraFra.getLineasFra();
       if (lista==null)
           return;
       lineaOutputDtoList=cabeceraFra.getLineasFra().stream()
               .map( LineaOutputDto::new )
               .collect(Collectors.toList());
        clienteOutputDto=new ClienteOutputDto(cabeceraFra.getCliente());
    }
}
