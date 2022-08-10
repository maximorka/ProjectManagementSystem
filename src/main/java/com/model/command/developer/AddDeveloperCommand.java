package com.model.command.developer;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.customer.entity.Customer;
import com.model.feature.dataBaseService.developer.entity.Developer;
import com.model.feature.dataBaseService.developer.util.SexEnum;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddDeveloperCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        int salary = 0;
        int company_id = 0;
        int age = 0;

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
            company_id = Integer.parseInt(req.getParameter("companyId"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Developer developer = new Developer();
        developer.setName(name);
        developer.setSurname(surname);
        developer.setAge(age);
        developer.setSex(sexEnum);
        developer.setSalary(salary);
        developer.setCompany_id(company_id);

        try {
            Model.getINSTANCE().developerDao.createDeveloper(developer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/developer");
    }
}
