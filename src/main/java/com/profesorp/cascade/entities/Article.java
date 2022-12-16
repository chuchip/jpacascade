package com.profesorp.cascade.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Article {
	@Id
	@GeneratedValue
	//@Column(name="id_article")
	int id;
	
	@Column
	String description;

	String word;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="word",referencedColumnName = "word",updatable = false,insertable = false)
		//@JoinColumnOrFormula(formula = @JoinFormula(value="es",referencedColumnName = "isoCode"))
		}
	)
	List<Dictionary> dictionaries;

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", description='" + description + '\'' +
	//			", pricesArticle=" +  (pricesArticle==null?"": pricesArticle.stream().map(r -> r.toString()).collect(Collectors.joining())) +
	//			", currentPriceArticule=" + (currentPriceArticule==null?"":currentPriceArticule.toString()) +
//				", dictionaries="+(dictionaries==null?"":"Iso "+dictionaries.getIsoCode()+" Translation: "+ dictionaries.getTranslation())+
				", dictionaries="+(dictionaries==null?"":dictionaries.stream().map(r -> "Iso: "+r.getIsoCode()+" Translation: "+ r.getTranslation()+ "\n").collect(Collectors.joining()))+
				'}';
	}
}
