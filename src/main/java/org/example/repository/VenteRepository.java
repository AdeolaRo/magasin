package org.example.repository;

import org.example.entity.*;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.time.LocalDate;
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
            session.update(vente);
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


    public List<Vente> findVenteByDate(LocalDate date) {
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Vente v where v.dateVente = :date");
        q.setParameter("date", date);
        List<Vente> venteList = q.getResultList();
//        for (Vente vente : venteList) {
//            System.out.println(vente);
//        }
        return venteList;
    }

}
