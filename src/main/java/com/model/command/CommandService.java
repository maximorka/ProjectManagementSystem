package com.model.command;

import com.model.command.company.AddCompanyCommand;
import com.model.command.company.DeleteCompanyCommand;
import com.model.command.company.GetCompanyCommand;
import com.model.command.company.UpdateCompanyCommand;
import com.model.command.customer.AddCustomerCommand;
import com.model.command.customer.DeleteCustomerCommand;
import com.model.command.customer.GetAllCustomer;
import com.model.command.customer.UpdateCustomerCommand;
import com.model.command.developer.AddDeveloperCommand;
import com.model.command.developer.DeleteDeveloperCommand;
import com.model.command.developer.GetAllDeveloper;
import com.model.command.developer.UpdateDeveloperCommand;
import com.model.command.developerProject.AddDeveloperProjectCommand;
import com.model.command.developerProject.DeleteDeveloperProjectCommand;
import com.model.command.developerProject.GetAllDeveloperProject;
import com.model.command.developerSkills.AddDeveloperSkillsCommand;
import com.model.command.developerSkills.DeleteDeveloperSkillsCommand;
import com.model.command.developerSkills.GetAllDeveloperSkills;
import com.model.command.project.AddProjectCommand;
import com.model.command.project.DeleteProjectCommand;
import com.model.command.project.GetAllProject;
import com.model.command.project.UpdateProjectCommand;
import com.model.command.skills.AddSkillsCommand;
import com.model.command.skills.DeleteSkillsCommand;
import com.model.command.skills.GetAllSkills;
import com.model.command.skills.UpdateSkillsCommand;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService {
    private Map<String, Command> commands;

    public CommandService() {
        commands = new HashMap<>();
        commands.put("GET /main", new GetMainCommand());
        commands.put("GET /info", new GetInfo());

        commands.put("GET /company", new GetCompanyCommand());
        commands.put("POST /company", new AddCompanyCommand());
        commands.put("POST /company/delete", new DeleteCompanyCommand());
        commands.put("POST /company/update", new UpdateCompanyCommand());

        commands.put("GET /project", new GetAllProject());
        commands.put("POST /project", new AddProjectCommand());
        commands.put("POST /project/delete", new DeleteProjectCommand());
        commands.put("POST /project/update", new UpdateProjectCommand());

        commands.put("GET /customer", new GetAllCustomer());
        commands.put("POST /customer", new AddCustomerCommand());
        commands.put("POST /customer/delete", new DeleteCustomerCommand());
        commands.put("POST /customer/update", new UpdateCustomerCommand());

        commands.put("GET /developer", new GetAllDeveloper());
        commands.put("POST /developer", new AddDeveloperCommand());
        commands.put("POST /developer/delete", new DeleteDeveloperCommand());
        commands.put("POST /developer/update", new UpdateDeveloperCommand());

        commands.put("GET /skills", new GetAllSkills());
        commands.put("POST /skills", new AddSkillsCommand());
        commands.put("POST /skills/delete", new DeleteSkillsCommand());
        commands.put("POST /skills/update", new UpdateSkillsCommand());

        commands.put("GET /developer_project", new GetAllDeveloperProject());
        commands.put("POST /developer_project", new AddDeveloperProjectCommand());
        commands.put("POST /developer_project/delete", new DeleteDeveloperProjectCommand());

        commands.put("GET /developer_skills", new GetAllDeveloperSkills());
        commands.put("POST /developer_skills", new AddDeveloperSkillsCommand());
        commands.put("POST /developer_skills/delete", new DeleteDeveloperSkillsCommand());

    }

    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String reqUri = req.getRequestURI();
        String commandKey = req.getMethod() + " " + reqUri;

        commands.get(commandKey).procces(req, resp, engine);
    }
}
