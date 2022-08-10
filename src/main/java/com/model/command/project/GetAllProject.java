package com.model.command.project;

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

public class GetAllProject implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");



        resp.setContentType("text/html");
        Map<String, Object> projects = new HashMap<>();

        try {
            projects.put("projects", Model.getINSTANCE().getProjectDao().getAllProject());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Context context = new Context(
            req.getLocale(),
                projects
        );
        templateEngine.process("project", context,resp.getWriter());
        resp.getWriter().close();
    }
}
