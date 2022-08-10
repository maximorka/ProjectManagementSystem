package com.model.command.developer;

import com.model.Model;
import com.model.command.Command;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GetAllDeveloper implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");

        Map<String, Object> developer = new HashMap<>();

        try {
            developer.put("developers", Model.getINSTANCE().getDeveloperDao().getAllDevelopers());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Context context = new Context(
                req.getLocale(),
                developer
        );
        templateEngine.process("developer", context,resp.getWriter());
        resp.getWriter().close();
    }
}
