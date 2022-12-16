package com.profesorp.cascade;

import com.profesorp.cascade.entities.*;
import com.profesorp.cascade.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CascadeApplication {


	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	DictionaryRepository dictionaryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CascadeApplication.class, args);
	}

	@Bean
	CommandLineRunner cargaSQL()
	{
		return p -> {

			//test1();
			test2();
			System.out.println(" ----------------------------");
			System.out.println(" Fin inicializacion ");
		};
	}
	private void test2() {
		Dictionary dictionary1=new Dictionary();
		dictionary1.setWord("1");
		dictionary1.setIsoCode("es");
		dictionary1.setTranslation("Deporte");
		dictionaryRepository.save(dictionary1);

		Dictionary dictionary2=new Dictionary();
		dictionary2.setWord("1");
		dictionary2.setIsoCode("en");
		dictionary2.setTranslation("Sport");
		dictionaryRepository.save(dictionary2);

		Article articulo=new Article();
		articulo.setDescription("Articulo 1");
		articulo.setWord("1");
		articleRepository.save(articulo);

		articleRepository.save(articulo);

		imprimeArticulos();
	}
	/*private void test1() {
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


	}*/
	void imprimeArticulos()
	{
		System.out.println(" Iniciando ");
		System.out.println(" ----------------------------");
		articleRepository.findAll().stream().forEach( r1-> System.out.println(r1.toString()));
	}
}
