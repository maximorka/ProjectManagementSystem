package com.model.command.developerSkills;

import com.model.Model;
import com.model.command.Command;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDeveloperSkillsCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        System.out.println("req.getParameter(\"develop_id\") = " + req.getParameter("develop_id"));
        long dev_id = Long.parseLong(req.getParameter("develop_id"));
        long skills_id = Long.parseLong(req.getParameter("skills_id"));

        Model.getINSTANCE().developerSkillsDao.deleteDeveloperSkills(dev_id,skills_id);
        resp.sendRedirect("/developer_skills");
    }
}
