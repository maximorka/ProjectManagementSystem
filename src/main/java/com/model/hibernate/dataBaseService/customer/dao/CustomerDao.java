package com.model.hibernate.dataBaseService.customer.dao;

import com.model.hibernate.HibernateUtil;
import com.model.hibernate.dataBaseService.customer.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;


public class CustomerDao {

    HibernateUtil util = HibernateUtil.getINSTANCE();

    public void createCustomer(Customer customer){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        session.close();
    }

    public Customer getById(long id) {

        Session session = util.getSessionFactory().openSession();
        Query<Customer> query = session.createQuery("from Customer c WHERE c.id = :id", Customer.class);
        query.setParameter("id", id);
        Customer result = query.getSingleResult();
        session.close();
        return result;
    }

    public List<Customer> getAllCustomers() {

        Session session = util.getSessionFactory().openSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void deleteById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Customer where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public void updateCustomer(Customer customer) {

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(customer);
        transaction.commit();
        session.close();

    }
}
