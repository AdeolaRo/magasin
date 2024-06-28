package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder


public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_client")
    private int id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "client")
    @Column(name = "Historique_achats")
    private List<Vente> historiqueAchats;

}


