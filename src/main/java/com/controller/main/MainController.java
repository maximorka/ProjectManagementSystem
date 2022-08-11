package com.controller.main;

import com.model.Model;
import com.model.command.CommandService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/*"}, asyncSupported = true)
public class MainController extends HttpServlet {
    private TemplateEngine engine;
    private CommandService commandService;


    @Override
    public void init() {
        Model.getINSTANCE().getCompanyDao();

        engine = new TemplateEngine();

        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("templates/");

        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(engine.getTemplateResolvers().size());
        templateResolver.setCacheable(false);
        engine.addTemplateResolver(templateResolver);

        commandService = new CommandService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        commandService.process(req, resp, engine);
    }

}
