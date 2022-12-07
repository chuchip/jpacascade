package com.profesorp.cascade.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinFormula;

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

	@OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
	List<PriceArticle> pricesArticle;

	@ManyToOne()
	@JoinFormula("(SELECT p.id_price_article FROM price_article p WHERE p.article_id = id ORDER BY p.posted_at DESC LIMIT 1)")
	PriceArticle currentPriceArticule;

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", description='" + description + '\'' +
				", pricesArticle=" + pricesArticle.stream().map(r -> r.toString()).collect(Collectors.joining()) +
				", currentPriceArticule=" + currentPriceArticule.toString() +
				'}';
	}
}
