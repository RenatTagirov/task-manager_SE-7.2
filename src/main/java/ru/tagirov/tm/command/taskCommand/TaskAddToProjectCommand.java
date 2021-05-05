package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;
import java.util.Map;

public class TaskAddToProjectCommand extends AbstractCommand {

    public TaskAddToProjectCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task add to project";
    }

    @Override
    public String getDescription() {
        return "move the selected task to the project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(Bootstrap.user == null)) {
            System.out.println("[TASK ADD TO PROJECT]");
            System.out.println("ENTER TASK NAME:");
            nameTask = TerminalService.service();
            System.out.println("ENTER PROJECT NAME:");
            nameProject = TerminalService.service();
            String id1 = null;
            String name1 = null;
            String description1 = null;
            String dateCreate1 = null;
            String id2 = null;
            for (Task tmp : serviceLocator.getITaskService().findAll()) {
                if (tmp.getName().equals(nameTask) && tmp.getUserId().equals(Bootstrap.user.getId())) {
                    id1 = tmp.getId();
                    name1 = tmp.getName();
                    description1 = tmp.getDescription();
                    dateCreate1 = tmp.getDateCreate();
                }
            }
            for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                if (tmp.getName().equals(nameProject) && tmp.getUserId().equals(Bootstrap.user.getId())) {
                    tmp.taskListToProject.add(new Task(id1, name1, description1, dateCreate1, Bootstrap.user.getId()));
                    id2 = tmp.getId();
                }
            }
            for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                if (tmp.getName().equals(nameProject) && tmp.getUserId().equals(Bootstrap.user.getId())) {
                    for (int i = 0; i < tmp.taskListToProject.size(); i++) {
                        if (tmp.taskListToProject.get(i).getName().equals(nameTask)) {
                            tmp.taskListToProject.get(i).setIdProject(id2);
                        }
                    }
                }
            }

            for (Task tmp : serviceLocator.getITaskService().findAll()) {
                if (tmp.getName().equals(nameTask) && tmp.getUserId().equals(Bootstrap.user.getId())) {
                    serviceLocator.getIUserService().remove(tmp.getId());
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
