package com.profesorp.cascade.controllers.dtos;

import com.profesorp.cascade.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


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
