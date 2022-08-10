package com.model.command.developer;

import com.model.Model;
import com.model.command.Command;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDeveloperCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
       int id = Integer.parseInt(req.getParameter("id"));

        Model.getINSTANCE().developerDao.deleteById(id);
        resp.sendRedirect("/developer");
    }
}
