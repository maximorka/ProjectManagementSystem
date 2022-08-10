package com.model.command.developerProject;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.developer_project.entity.DeveloperProject;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDeveloperProjectCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        long dev_id = Long.parseLong(req.getParameter("develop_id"));
        long proj_id = Long.parseLong(req.getParameter("project_id"));

        Model.getINSTANCE().developerProjectDao.deleteDeveloperProject(dev_id,proj_id);
        resp.sendRedirect("/developer_project");
    }
}
