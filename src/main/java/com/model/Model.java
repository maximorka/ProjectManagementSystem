package com.model;

import com.model.hibernate.dataBaseService.customer.dao.CustomerDao;
import com.model.hibernate.dataBaseService.company.dao.CompanyDao;
import com.model.hibernate.dataBaseService.developer.dao.DeveloperDao;
import com.model.hibernate.dataBaseService.project.dao.ProjectDao;
import com.model.hibernate.dataBaseService.skills.dao.SkillsDao;
import com.model.feature.storage.DataBaseInit;

import lombok.Getter;

import static com.model.feature.storage.StorageConstants.CONNECTION_URL;

public class Model {

    @Getter
    public ProjectDao projectDao;

    @Getter
    public DeveloperDao developerDao;
    @Getter
    public SkillsDao skillsDao;
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
            new DataBaseInit().initDB(CONNECTION_URL);
            projectDao = new ProjectDao();
            skillsDao = new SkillsDao();
            developerDao = new DeveloperDao();
            companyDao = new CompanyDao();
            customerDao = new CustomerDao();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Model.getINSTANCE().settings();
    }
}
