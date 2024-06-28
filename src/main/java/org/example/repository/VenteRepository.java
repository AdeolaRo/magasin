package org.example.repository;

import org.example.entity.*;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class VenteRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public VenteRepository() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public Vente create(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(vente);
            session.getTransaction().commit();
            return vente;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(vente);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Vente update(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(vente);
            session.getTransaction().commit();
            return vente;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Vente findById(int id) {
        session = sessionFactory.openSession();
        Vente vente = session.get(Vente.class, id);
        session.close();
        return vente;
    }

}
