package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class AdminShowTaskToProjectToUserCommand extends AbstractCommand {

    public AdminShowTaskToProjectToUserCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show tasks to project user";
    }

    @Override
    public String getDescription() {
        return "view all user tasks in the project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for (User tmp : serviceLocator.getIUserService().findAll()) {
                if (tmp.getName().equals(name)) {
                    for (Project tmp1 : serviceLocator.getIProjectService().findAll()) {
                        if (!(tmp1.taskListToProject.isEmpty())) {
                            System.out.println("ENTER PROJECT NAME:");
                            nameProject = reader.readLine();
                            int count = 1;
                            if (tmp1.getName().equals(nameProject) && tmp1.getUserId().equals(tmp.getId())) {
                                for (int i = 0; i < tmp1.taskListToProject.size(); i++) {
                                    if (tmp1.taskListToProject.get(i).getDateUpdate() == null) {
                                        System.out.println(count + ". " + "Task name:");
                                        System.out.println(tmp1.taskListToProject.get(i).getName());
                                        System.out.println("Task description:");
                                        System.out.println(tmp1.taskListToProject.get(i).getDescription());
                                        System.out.println("Date create:");
                                        System.out.println(tmp1.taskListToProject.get(i).getDateCreate());
                                        System.out.println();
                                        count++;
                                    } else {
                                        System.out.println(count + ". " + "Task name:");
                                        System.out.println(tmp1.taskListToProject.get(i).getName());
                                        System.out.println("Task description:");
                                        System.out.println(tmp1.taskListToProject.get(i).getDescription());
                                        System.out.println("Date create:");
                                        System.out.println(tmp1.taskListToProject.get(i).getDateCreate());
                                        System.out.println("Date update:");
                                        System.out.println(tmp1.taskListToProject.get(i).getDateUpdate());
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
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
