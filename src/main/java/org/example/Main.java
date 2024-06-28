package org.example;

import org.example.entity.*;
import org.example.repository.ArticleRepository;
import org.example.repository.ClientRepository;
import org.example.repository.VenteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArticleRepository articleRepository = new ArticleRepository();
        ClientRepository clientRepository = new ClientRepository();
        VenteRepository venteRepository = new VenteRepository();

        Nourriture Thon = Nourriture.builder()
                .description("Thon de la mer")
                .prix(12.5)
                .quantiteEnStock(25)
                .dateRestock(LocalDate.now())
                .dateDePereemption(LocalDate.now())
                .build();

        articleRepository.create(Thon);




        Client c1 = Client.builder()
                .nom("Léo B")
                .email("leob.gmail.com")
                .build();

        Client c2 = Client.builder()
                .nom("Charles V")
                .email("charlesv.gmail.com")
                .build();

        Client c3 = Client.builder()
                .nom("Hector D")
                .email("hectord.gmail.com")
                .build();


        clientRepository.create(c1);
        clientRepository.create(c2);
        clientRepository.create(c3);


        Vente v1 = Vente.builder()
                .client(c2)
                .etatVente("finalisée")
                .dateVente(LocalDate.of(2023,11,11))
                .build();

        Vente v2 = new Vente();
        v2.setClient(c2);
        v2.setEtatVente("finalisée");
        v2.setDateVente(LocalDate.of(2023,11,11));

                v2.addArticle(Thon);


        venteRepository.create(v1);
        venteRepository.create(v2);

    }


}