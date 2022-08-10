package com.model.command.customer;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.company.entity.Company;
import com.model.feature.dataBaseService.customer.entity.Customer;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);


        try {
            Model.getINSTANCE().customerDao.createCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.sendRedirect("/customer");
    }
}
