package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionfactorySingleton {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    //constructeur en privé pour etre sur d'avoir une seul instance de session factory crée
    private SessionfactorySingleton() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    //methode nous permetant de venir recupere toujour la meme instance de notre session factory
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new org.example.util.SessionfactorySingleton();
        }
        return sessionFactory;
    }

}
