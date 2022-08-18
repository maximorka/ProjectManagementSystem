package com.model.hibernate;


import com.model.feature.storage.StorageConstants;
import com.model.hibernate.dataBaseService.company.entity.Company;
import com.model.hibernate.dataBaseService.customer.entity.Customer;
import com.model.hibernate.dataBaseService.developer.entity.Developer;
import com.model.hibernate.dataBaseService.project.entity.Project;
import com.model.hibernate.dataBaseService.skills.entity.Skills;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }

    @Getter
    SessionFactory sessionFactory;

    public HibernateUtil() {

        sessionFactory = new Configuration()
                .setProperty("hibernate.connection.url", StorageConstants.CONNECTION_URL)
                .addAnnotatedClass(Skills.class)
                .addAnnotatedClass(Developer.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getINSTANCE() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }


}
