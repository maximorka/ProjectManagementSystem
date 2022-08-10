package com.model.command;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMainCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
        resp.setContentType("text/html");

        Context context = new Context();
        templateEngine.process("main",context,resp.getWriter());

        resp.getWriter().close();
    }
}
