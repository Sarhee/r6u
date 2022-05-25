package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;

import java.util.List;

public class ProductService implements Dao<Product, Integer> {
    private final SessionFactory factory;

    public ProductService (SessionFactory factory){
        this.factory = factory;
    }



    @Override
    public Product findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Product.class, id);
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("From Product", Product.class).list();
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }

    @Override
    public void update(Product product) {
        try (Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        }
    }

    @Override
    public void delete(Product product) {
        try (Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }
    }
}
