package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.TerminalService;
import ru.tagirov.tm.util.UUIDUtil;

import java.io.IOException;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "project create";
    }

    @Override
    public String getDescription() {
        return "create a new project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)) {
            System.out.println("[PROJECT CREATE]");
            System.out.println("ENTER NAME:");
            nameProject = TerminalService.service();
            System.out.println("ENTER DESCRIPTION:");
            description = TerminalService.service();
            dateCreate = DateUtil.getDate();
            id = UUIDUtil.getUuid();
            serviceLocator.getIProjectService().persist(new Project(id, nameProject, description, dateCreate, Bootstrap.user.getId()));
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
