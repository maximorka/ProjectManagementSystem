package com.model.command.developerProject;

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

public class GetAllDeveloperProject implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");



        resp.setContentType("text/html");
        Map<String, Object> developer_projects = new HashMap<>();

        try {
            developer_projects.put("developer_projects", Model.getINSTANCE().getDeveloperProjectDao().getAllDeveloperProject());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Context context = new Context(
            req.getLocale(),
                developer_projects
        );
        templateEngine.process("developer_project", context,resp.getWriter());
        resp.getWriter().close();
    }
}
