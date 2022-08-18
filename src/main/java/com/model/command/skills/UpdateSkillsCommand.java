package com.model.command.skills;

import com.model.Model;
import com.model.command.Command;
import com.model.hibernate.dataBaseService.skills.entity.Skills;
import com.model.hibernate.dataBaseService.skills.util.SkillsLevel;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSkillsCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        Skills skills = new Skills();
        String kategory = req.getParameter("kategory");
        skills.setKategory(kategory);
        long id = Long.parseLong(req.getParameter("id"));
        skills.setId(id);
        try {
            SkillsLevel level = SkillsLevel.valueOf(req.getParameter("level"));
            skills.setLevel(level);
        } catch (Exception e) {
            resp.sendRedirect("/skills");
            e.printStackTrace();
        }


        Model.getINSTANCE().skillsDao.updateSkills(skills);

        resp.sendRedirect("/skills");
    }
}
