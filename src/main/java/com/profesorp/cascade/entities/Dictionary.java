package com.profesorp.cascade.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
public class Dictionary {
    @Id
    @GeneratedValue
    int id;

    String word;

    String isoCode;

    String translation;
}
