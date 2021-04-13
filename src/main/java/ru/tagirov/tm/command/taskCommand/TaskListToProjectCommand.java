package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.util.Map;

public class TaskListToProjectCommand extends AbstractCommand {

    public TaskListToProjectCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task list to project";
    }

    @Override
    public String getDescription() {
        return "view all available tasks in the project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[TASK LIST TO PROJECT]");
            System.out.println("ENTER PROJECT NAME:");
            nameProject = reader.readLine();
            int count = 1;
            if (!(serviceLocator.getIProjectService().findAll().isEmpty())) {
                for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                    if (!(tmp.taskListToProject.isEmpty())) {
                        if (tmp.getName().equals(nameProject) && tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                            for (int i = 0; i < tmp.taskListToProject.size(); i++) {
                                if (tmp.taskListToProject.get(i).getDateUpdate() == null) {
                                    System.out.println(count + ". " + "Task name:");
                                    System.out.println(tmp.taskListToProject.get(i).getName());
                                    System.out.println("Task description:");
                                    System.out.println(tmp.taskListToProject.get(i).getDescription());
                                    System.out.println("Date create:");
                                    System.out.println(tmp.taskListToProject.get(i).getDateCreate());
                                    System.out.println();
                                    count++;
                                } else {
                                    System.out.println(count + ". " + "Task name:");
                                    System.out.println(tmp.taskListToProject.get(i).getName());
                                    System.out.println("Task description:");
                                    System.out.println(tmp.taskListToProject.get(i).getDescription());
                                    System.out.println("Date create:");
                                    System.out.println(tmp.taskListToProject.get(i).getDateCreate());
                                    System.out.println("Date update:");
                                    System.out.println(tmp.taskListToProject.get(i).getDateUpdate());
                                    System.out.println();
                                    count++;
                                }
                            }
                        } else {
                            System.out.println("[YOUR PROJECT NAME IS INVALID]");
                            System.out.println();
                        }
                    } else {
                        System.out.println("[EMPTY]");
                        System.out.println();
                    }
                }
            } else {
                System.out.println("[EMPTY]");
                System.out.println();
            }
        }else {
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
