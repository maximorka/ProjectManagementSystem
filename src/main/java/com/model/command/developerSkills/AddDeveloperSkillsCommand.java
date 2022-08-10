package com.model.command.developerSkills;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.developerSkills.entity.DeveloperSkills;
import com.model.feature.dataBaseService.developer_project.entity.DeveloperProject;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddDeveloperSkillsCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        DeveloperSkills developerSkills = new DeveloperSkills();
        long dev_id = Long.parseLong(req.getParameter("develop_id"));
        long skills_id = Long.parseLong(req.getParameter("skills_Id"));
        developerSkills.setDevId(dev_id);
        developerSkills.setSkillsId(skills_id);
        try {
            Model.getINSTANCE().developerSkillsDao.createDeveloperSkills(developerSkills);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/developer_skills");
    }
}
