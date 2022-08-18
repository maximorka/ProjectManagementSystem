package com.model.hibernate.dataBaseService.developer.dao;

import com.model.hibernate.HibernateUtil;
import com.model.hibernate.dataBaseService.developer.entity.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;


public class DeveloperDao {
    HibernateUtil util = HibernateUtil.getINSTANCE();

    public void createDeveloper(Developer developer)  {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(developer);
        transaction.commit();
        session.close();
    }

    public Developer getDeveloperById(long id)  {
        Session session = util.getSessionFactory().openSession();
        Query<Developer> query = session.createQuery("from Developer c WHERE c.id = :id", Developer.class);
        query.setParameter("id", id);
        Developer result = query.getSingleResult();
        session.close();
        return result;
    }

    public List<Developer> getAllDevelopers()  {
        System.out.println("GET");
        Session session = util.getSessionFactory().openSession();
        Query<Developer> query = session.createQuery("from Developer", Developer.class);
        List<Developer> resultList = query.getResultList();
        System.out.println("resultList = " + resultList);
        session.close();
        return resultList;
    }

    public void deleteById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Developer where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public void updateDeveloper(Developer developer) {

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(developer);
        transaction.commit();
        session.close();

    }
}
