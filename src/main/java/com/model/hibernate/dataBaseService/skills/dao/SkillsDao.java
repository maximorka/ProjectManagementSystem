package com.model.hibernate.dataBaseService.skills.dao;

import com.model.hibernate.HibernateUtil;
import com.model.hibernate.dataBaseService.company.entity.Company;
import com.model.hibernate.dataBaseService.skills.entity.Skills;
import com.model.hibernate.dataBaseService.skills.util.SkillsLevel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillsDao {

    HibernateUtil util = HibernateUtil.getINSTANCE();


    public void create(Skills skills){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(skills);
        transaction.commit();
        session.close();
    }

    public Skills getById(long id)  {
        Session session = util.getSessionFactory().openSession();
        Query<Skills> query = session.createQuery("from Skills c WHERE c.id = :id", Skills.class);
        query.setParameter("id", id);
        Skills result = query.getSingleResult();
        session.close();
        return result;
    }

    public List<Skills> getAllSkills()  {
        Session session = util.getSessionFactory().openSession();
        Query<Skills> query = session.createQuery("from Skills", Skills.class);
        List<Skills> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void deleteById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Skills where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    public void updateSkills(Skills skills) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(skills);
        transaction.commit();
        session.close();

    }
}
