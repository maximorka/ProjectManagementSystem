package com.model.hibernate.dataBaseService.project.dao;

import com.model.hibernate.HibernateUtil;
import com.model.hibernate.dataBaseService.project.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDao {


    HibernateUtil util = HibernateUtil.getINSTANCE();

    public void createProject(Project project)  {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(project);
        transaction.commit();
        session.close();

    }

    public Project getById(long id)  {
        Session session = util.getSessionFactory().openSession();
        Query<Project> query = session.createQuery("from Project  WHERE id = :id", Project.class);
        query.setParameter("id", id);
        Project result = query.getSingleResult();
        session.close();
        return result;
    }

    public List<Project> getAllProject()  {
        Session session = util.getSessionFactory().openSession();
        Query<Project> query = session.createQuery("from Project", Project.class);
        List<Project> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void deleteById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Project where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void updateProject(Project project) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(project);
        transaction.commit();
        session.close();
    }

    public Project getProjectByName(String name)  {
        Session session = util.getSessionFactory().openSession();
        Query<Project> query = session.createQuery("from Project c WHERE c.name = :name", Project.class);
        query.setParameter("name", name);
        Project result = query.getSingleResult();
        session.close();
        return result;
    }
}
