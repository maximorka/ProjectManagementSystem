package com.model.command.company;

import com.model.command.Command;
import com.model.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GetCompanyCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");



        resp.setContentType("text/html");

        Map<String, Object> objectObjectMap = new HashMap<>();
        try {
            objectObjectMap.put("companies", Model.getINSTANCE().getCompanyDao().getAllCompany());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Context context = new Context(
                req.getLocale(),
                objectObjectMap
        );

        templateEngine.process("company",context,resp.getWriter());
        resp.getWriter().close();
    }


}
