package com.model.hibernate.dataBaseService.company.dao;

import com.model.hibernate.HibernateUtil;
import com.model.hibernate.dataBaseService.company.entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDao {

    HibernateUtil util = HibernateUtil.getINSTANCE();

    public void create(Company company)  {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(company);
        transaction.commit();
        session.close();
    }

    public Company getById(long id){

        Session session = util.getSessionFactory().openSession();
        Query<Company> query = session.createQuery("from Company WHERE id = :id", Company.class);
        query.setParameter("id", id);
        Company result = query.getSingleResult();
        session.close();
        return result;
    }

    public List<Company> getAllCompany(){
        Session session = util.getSessionFactory().openSession();
        Query<Company> query = session.createQuery("from Company", Company.class);
        List<Company> resultList = query.getResultList();
        query.setCacheable(false);
        session.close();
        return resultList;
    }

    public void deleteById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Company where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public void updateCompany(Company newCompany) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(newCompany);
        transaction.commit();
        session.close();

    }
}
