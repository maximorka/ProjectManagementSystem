package com.model.command.customer;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.company.entity.Company;
import com.model.feature.dataBaseService.customer.entity.Customer;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCustomerCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setId(id);

        Model.getINSTANCE().customerDao.updateCustomer(customer);

        resp.sendRedirect("/customer");
    }
}
