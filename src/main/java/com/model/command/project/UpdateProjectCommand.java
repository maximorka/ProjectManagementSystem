package com.model.command.project;

import com.model.Model;
import com.model.command.Command;
import com.model.feature.dataBaseService.company.entity.Company;
import com.model.feature.dataBaseService.project.entity.Project;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProjectCommand implements Command {
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine templateEngine) throws IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Integer companyId = Integer.parseInt(req.getParameter("companyId"));
        Integer customerId = Integer.parseInt(req.getParameter("customerId"));
        String cost = req.getParameter("cost");
        Integer id = Integer.parseInt(req.getParameter("id"));

        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.setCompany_id(companyId);
        project.setCustomer_id(customerId);
        project.setCost(Integer.parseInt(cost));
        project.setId(id);

        Model.getINSTANCE().projectDao.updateProject(project);

        resp.sendRedirect("/project");
    }
}
