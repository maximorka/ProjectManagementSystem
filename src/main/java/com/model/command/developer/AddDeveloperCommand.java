package com.model.command.developer;

import com.model.Model;
import com.model.command.Command;


import com.model.hibernate.dataBaseService.skills.entity.Skills;
import com.model.hibernate.dataBaseService.developer.entity.Developer;
import com.model.hibernate.dataBaseService.developer.util.SexEnum;
import com.model.hibernate.dataBaseService.project.entity.Project;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AddDeveloperCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        long devId = 0;
        int salary = 0;
        int companyId = 0;
        int age = 0;
        int projectId = 0;
        int skillsId = 0;

        SexEnum sexEnum = SexEnum.unknown;
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sexEnum = SexEnum.valueOf(req.getParameter("sex"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            salary = Integer.parseInt(req.getParameter("salary"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            companyId = Integer.parseInt(req.getParameter("companyId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            projectId = Integer.parseInt(req.getParameter("projectId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            skillsId = Integer.parseInt(req.getParameter("skillsId"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Developer developer = new Developer();
        developer.setName(name);
        developer.setSurname(surname);
        developer.setAge(age);
        developer.setSex(sexEnum);
        developer.setSalary(salary);
        developer.setCompany(Model.getINSTANCE().companyDao.getById(companyId));

        Set<Project> projects = new HashSet<Project>();
        projects.add(Model.getINSTANCE().projectDao.getById(projectId));
        developer.setProjects(projects);

        Set<Skills> skills = new HashSet<Skills>();
        skills.add(Model.getINSTANCE().skillsDao.getById(skillsId));
        developer.setSkills(skills);


        Model.getINSTANCE().developerDao.createDeveloper(developer);


        resp.sendRedirect("/developer");
    }
}
