package com.profesorp.cascade;

import com.profesorp.cascade.entities.*;
import com.profesorp.cascade.repositories.ArticleRepository;
import com.profesorp.cascade.repositories.CabeceraFraRepository;
import com.profesorp.cascade.repositories.ClienteRepository;
import com.profesorp.cascade.repositories.PriceArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CascadeApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	CabeceraFraRepository cabeceraFraRepository;
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	PriceArticleRepository priceArticleRepository;
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

			Article articulo=new Article();
			articulo.setDescription("Articulo 1");

			articleRepository.save(articulo);

			PriceArticle priceArticle = new PriceArticle();
			priceArticle.setArticle(articulo);
			priceArticle.setPrecio(1);
			priceArticleRepository.save(priceArticle);



			PriceArticle priceArticle2 = new PriceArticle();
			priceArticle2.setArticle(articulo);
			priceArticle2.setPrecio(2);
			priceArticleRepository.save(priceArticle2);

			System.out.println(" Iniciando ");
			System.out.println(" ----------------------------");
			articleRepository.findAll().stream().forEach( r1-> System.out.println(r1.toString()));

			System.out.println(" ----------------------------");
			System.out.println(" Fin inicializacion ");
		};
	}
}
