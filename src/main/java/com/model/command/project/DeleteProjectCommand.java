package com.model.command.project;

import com.model.Model;
import com.model.command.Command;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProjectCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
       int id = Integer.parseInt(req.getParameter("id"));

        Model.getINSTANCE().projectDao.deleteById(id);
        resp.sendRedirect("/project");
    }
}
