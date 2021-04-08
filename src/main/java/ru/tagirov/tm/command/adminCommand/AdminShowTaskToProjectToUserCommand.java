package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class AdminShowTaskToProjectToUserCommand extends AbstractCommand {

    public AdminShowTaskToProjectToUserCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
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
    public void execute() throws IOException {
        if (!(bootstrap.user == null)) {
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for (Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                if (tmp.getValue().getUserName().equals(name)) {
                    for (Map.Entry<String, Project> tmp1 : bootstrap.projectService.findAll().entrySet()) {
                        if (!(tmp1.getValue().taskListToProject.isEmpty())) {
                            System.out.println("ENTER PROJECT NAME:");
                            nameProject = reader.readLine();
                            int count = 1;
                            if (tmp1.getValue().getName().equals(nameProject) && tmp1.getValue().getUserId().equals(tmp.getValue().getUserId())) {
                                for (int i = 0; i < tmp1.getValue().taskListToProject.size(); i++) {
                                    if (tmp1.getValue().taskListToProject.get(i).getDateUpdate() == null) {
                                        System.out.println(count + ". " + "Task name:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getName());
                                        System.out.println("Task description:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getDescription());
                                        System.out.println("Date create:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getDateCreate());
                                        System.out.println();
                                        count++;
                                    } else {
                                        System.out.println(count + ". " + "Task name:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getName());
                                        System.out.println("Task description:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getDescription());
                                        System.out.println("Date create:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getDateCreate());
                                        System.out.println("Date update:");
                                        System.out.println(tmp1.getValue().taskListToProject.get(i).getDateUpdate());
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
