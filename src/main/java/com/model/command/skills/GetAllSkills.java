package com.model.command.skills;

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

public class GetAllSkills implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        resp.setContentType("text/event-stream");

        resp.setHeader("Cache-Control", "no-cache");

        resp.setCharacterEncoding("UTF-8");


        resp.setContentType("text/html");
        Map<String, Object> skills = new HashMap<>();


        skills.put("skills", Model.getINSTANCE().getSkillsDao().getAllSkills());


        Context context = new Context(
                req.getLocale(),
                skills
        );
        templateEngine.process("skills", context, resp.getWriter());
        resp.getWriter().close();
    }
}
