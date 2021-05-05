package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.TerminalService;
import ru.tagirov.tm.util.UUIDUtil;

import java.io.IOException;

public class TaskCreateToProjectCommand extends AbstractCommand {

    public TaskCreateToProjectCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task create to project";
    }

    @Override
    public String getDescription() {
        return "create a new task in the project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(Bootstrap.user == null)) {
            System.out.println("[TASK CREATE TO PROJECT]");
            System.out.println("ENTER PROJECT NAME:");
            nameProject = TerminalService.service();
            System.out.println("ENTER NAME:");
            nameTask = TerminalService.service();
            System.out.println("ENTER DESCRIPTION:");
            description = TerminalService.service();
            dateCreate = DateUtil.getDate();
            id = UUIDUtil.getUuid();
            for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                if (tmp.getName().equals(nameProject) && tmp.getUserId().equals(Bootstrap.user.getId())) {
                    tmp.taskListToProject.add(new Task(id, nameTask, description, dateCreate, Bootstrap.user.getId()));
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
