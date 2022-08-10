package com.model.command.company;

import com.model.command.Command;
import com.model.Model;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCompanyCommand  implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {
       int id = Integer.parseInt(req.getParameter("id"));

        Model.getINSTANCE().companyDao.deleteById(id);
        resp.sendRedirect("/company");
    }
}
