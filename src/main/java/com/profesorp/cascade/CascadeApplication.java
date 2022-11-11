package com.profesorp.cascade;

import com.profesorp.cascade.controllers.FacturaController;
import com.profesorp.cascade.entities.CabeceraFra;
import com.profesorp.cascade.entities.Cliente;
import com.profesorp.cascade.entities.LineaFra;
import com.profesorp.cascade.repositories.CabeceraFraRepository;
import com.profesorp.cascade.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CascadeApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	CabeceraFraRepository cabeceraFraRepository;
	public static void main(String[] args) {
		SpringApplication.run(CascadeApplication.class, args);
	}

	@Bean
	CommandLineRunner cargaSQL()
	{
		return p -> {
			Cliente cl=new Cliente();
			cl.setNombre("Jesus");
			clienteRepository.save(cl);


			var lineaFra1= new LineaFra("prod1",1,2);
			var lineaFra2= new LineaFra("prod2",10,20);


			CabeceraFra cabeceraFra = new CabeceraFra();
			cabeceraFra.setCliente(cl);
			cabeceraFra.setNumeroFra(1);
			cabeceraFra.setEjercicio(2022);
			cabeceraFra.setImporteFra(1);
			cabeceraFra.addLinea(lineaFra1);
			cabeceraFra.addLinea(lineaFra2);
			cabeceraFraRepository.save(cabeceraFra);


		};
	}
}
