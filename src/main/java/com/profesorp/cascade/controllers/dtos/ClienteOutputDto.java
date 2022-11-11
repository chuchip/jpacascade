package com.profesorp.cascade.controllers.dtos;

import com.profesorp.cascade.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Setter
@Getter
public class ClienteOutputDto {
    int id;
    String nombre;

    public ClienteOutputDto(Cliente cliente)
    {
        id=cliente.getId();
        nombre=cliente.getNombre();
    }
}
