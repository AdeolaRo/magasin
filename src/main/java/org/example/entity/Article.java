package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder


@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Article {

    @Id
    @GeneratedValue

    @Column(name = "id_article")
    protected int id;

    @Column(name = "Description")
    protected String description;

    @Column(name = "Prix")
    protected double prix;

    @Column(name = "Quantité_en_Stock")
    protected int quantiteEnStock;

    @Column(name = "Date_Restock")
    protected LocalDate dateRestock;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER)
    private List<Vente> ventes;

}
