package com.model.command.customer;

import com.model.Model;
import com.model.command.Command;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAllCustomer implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");

        Map<String, Object> customers = new HashMap<>();


        customers.put("customers", Model.getINSTANCE().getCustomerDao().getAllCustomers());


        Context context = new Context(
                req.getLocale(),
                customers
        );
        templateEngine.process("customer", context,resp.getWriter());
        resp.getWriter().close();
    }
}
