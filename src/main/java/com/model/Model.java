package com.model;

import com.model.feature.dataBaseService.customer.dao.CustomerDao;

import lombok.Getter;
import com.model.feature.dataBaseService.company.dao.CompanyDao;
import com.model.feature.dataBaseService.developer.dao.DeveloperDao;
import com.model.feature.dataBaseService.developerSkills.dao.DeveloperSkillsDao;
import com.model.feature.dataBaseService.developer_project.dao.DeveloperProjectDao;
import com.model.feature.dataBaseService.project.dao.ProjectDao;
import com.model.feature.dataBaseService.skills.dao.SkillsDao;

import com.model.feature.storage.DataBaseInit;
import com.model.feature.storage.Storage;


import java.sql.Connection;



public class Model {
    public static String DATABASE_CONNECTION_URL = "jdbc:h2:./testDB1";
   Storage storage;
    @Getter
    public ProjectDao projectDao;
    @Getter
    public DeveloperProjectDao developerProjectDao;
    @Getter
    public DeveloperDao developerDao;
    @Getter
    public SkillsDao skillsDao;
    @Getter
    public DeveloperSkillsDao developerSkillsDao;
    @Getter
    public  CompanyDao companyDao;
    @Getter
    public CustomerDao customerDao;
    private static final Model INSTANCE = new Model();
    private Model(){
        settings();
    }

    public static Model getINSTANCE() {
        return INSTANCE;
    }

    public void settings()  {
        try {
            new DataBaseInit().initDB(DATABASE_CONNECTION_URL);
            storage = Storage.getINSTANCE();
            Connection connection = storage.getConnection();
            projectDao = new ProjectDao(connection);
            developerProjectDao = new DeveloperProjectDao(connection);
            developerDao = new DeveloperDao(connection);
            skillsDao = new SkillsDao(connection);
            developerSkillsDao = new DeveloperSkillsDao(connection);
            companyDao = new CompanyDao(connection);
            customerDao = new CustomerDao(connection);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
