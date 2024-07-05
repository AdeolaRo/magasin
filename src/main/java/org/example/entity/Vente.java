package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor


public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_vente")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Vente_Article",
            joinColumns = @JoinColumn(name = "id_vente"),
            inverseJoinColumns = @JoinColumn(name = "id_article")
    )
    private List<Article> articles;

    @ManyToOne
    @JoinColumn(name = "id_client")
    Client client;

    private String etatVente;
    private LocalDate dateVente;


    public Vente() {
        articles = new ArrayList<>();
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    @Override
    public String toString() {
        return "Vente{" +
                "dateVente=" + dateVente +
                '}';
    }
}
