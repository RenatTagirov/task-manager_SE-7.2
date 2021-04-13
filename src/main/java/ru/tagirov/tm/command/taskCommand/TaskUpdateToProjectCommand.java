package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

import java.util.Map;

public class TaskUpdateToProjectCommand extends AbstractCommand {


    public TaskUpdateToProjectCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task update to project";
    }

    @Override
    public String getDescription() {
        return "edit the selected task in the project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[TASK UPDATE TO PROJECT]");
            System.out.println("ENTER PROJECT NAME:");
            nameProject = reader.readLine();
            for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                if (tmp.getName().equals(nameProject) && tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                    System.out.println("ENTER TASK NAME:");
                    nameTask = reader.readLine();
                    for (int i = 0; i < tmp.taskListToProject.size(); i++) {
                        if (tmp.taskListToProject.get(i).getName().equals(nameTask)) {
                            System.out.println("WHAT YOU WANT TO UPDATE?");
                            System.out.println("NAME OR DESCRIPTION:");
                            or = reader.readLine();
                            if (or.equalsIgnoreCase("name")) {
                                System.out.println("ENTER NEW NAME:");
                                tmp.taskListToProject.get(i).setName(reader.readLine());
                                tmp.taskListToProject.get(i).setDateUpdate(serviceLocator.getDate().getDate());
                                System.out.println("[OK]");
                                System.out.println();
                            } else if (or.equalsIgnoreCase("description")) {
                                System.out.println("ENTER NEW DESCRIPTION:");
                                tmp.taskListToProject.get(i).setDescription(reader.readLine());
                                tmp.taskListToProject.get(i).setDateUpdate(serviceLocator.getDate().getDate());
                                System.out.println("[OK]");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
