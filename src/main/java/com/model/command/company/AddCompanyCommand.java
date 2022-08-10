package com.model.command.company;

import com.model.command.Command;
import com.model.Model;
import com.model.feature.dataBaseService.company.entity.Company;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddCompanyCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");

        Company company = new Company();
        company.setName(name);
        company.setAddress(address);


        try {
            Model.getINSTANCE().companyDao.create(company);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/company");
    }
}
