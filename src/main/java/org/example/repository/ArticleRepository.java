package org.example.repository;

import org.example.entity.Article;
import org.example.entity.Vente;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ArticleRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ArticleRepository() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public Article create(Article article) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
            return article;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Article article) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(article);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Article update(Article article) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(article);
            session.getTransaction().commit();
            return article;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Article findById(int id) {
        session = sessionFactory.openSession();
        Article article = session.get(Article.class, id);
        session.close();
        return article;
    }


}
