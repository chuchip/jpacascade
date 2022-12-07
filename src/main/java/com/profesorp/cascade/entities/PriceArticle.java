package com.profesorp.cascade.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="price_article")
public class PriceArticle {
    @Id
    @GeneratedValue
    int idPriceArticle;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

   // @Column(name="posted_at")
    Date postedAt=new Date();
    double precio;

    @Override
    public String toString() {
        return "PriceArticle{" +
                "idArticle=" + idPriceArticle +
                ", article=" + article.getId() +
                ", precio=" + precio +
                '}';
    }
}
