package com.model.command.developerProject;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.developer_project.entity.DeveloperProject;
import com.model.feature.dataBaseService.skills.entity.Skills;
import com.model.feature.dataBaseService.skills.util.SkillsLevel;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddDeveloperProjectCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        DeveloperProject developerProject = new DeveloperProject();
        long dev_id = Long.parseLong(req.getParameter("develop_id"));
        long proj_id = Long.parseLong(req.getParameter("project_id"));
        developerProject.setDevelop_id(dev_id);
        developerProject.setProject_id(proj_id);
        try {
            Model.getINSTANCE().developerProjectDao.createDeveloperProject(developerProject);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/developer_project");
    }
}
