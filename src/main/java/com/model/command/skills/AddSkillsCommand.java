package com.model.command.skills;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.project.entity.Project;
import com.model.feature.dataBaseService.skills.entity.Skills;
import com.model.feature.dataBaseService.skills.util.SkillsLevel;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddSkillsCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        Skills skills = new Skills();
        String kategory = req.getParameter("kategory");
        try {
            SkillsLevel level = SkillsLevel.valueOf(req.getParameter("level"));
            skills.setKategory(kategory);
            skills.setLevel(level);
        }catch (Exception e){
            resp.sendRedirect("/skills");
            e.printStackTrace();
        }


        try {
            Model.getINSTANCE().skillsDao.create(skills);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/skills");
    }
}
