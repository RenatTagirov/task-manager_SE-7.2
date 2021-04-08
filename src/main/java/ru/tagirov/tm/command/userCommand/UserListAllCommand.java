package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserListAllCommand extends AbstractCommand {

    public UserListAllCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "list all";
    }

    @Override
    public String getDescription() {
        return "view all projects and tasks";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null)) {
            System.out.println("[LIST ALL]");
            int count = 1;
            if (bootstrap.user.getRole().getTitle().equals("user")) {
                if (!(bootstrap.projectService.findAll().isEmpty())) {
                    System.out.println("PROJECTS:");
                    for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                        System.out.println(count + ". " + "PROJECT NAME:");
                        System.out.println(tmp.getValue().getName());
                        count++;
                    }
                } else if (!(bootstrap.taskService.findAll().isEmpty())) {
                    count = 1;
                    System.out.println("TASKS:");
                    for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                        System.out.println(count + ". " + "TASK NAME:");
                        System.out.println(tmp.getValue().getName());
                        count++;
                    }
                } else {
                    System.out.println("[EMPTY]");
                    System.out.println();
                }
                System.out.println();
            }else if (bootstrap.user.getRole().getTitle().equals("admin")) {
                System.out.println("ENTER PROFILE NAME:");
                name = reader.readLine();
                for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                    if (tmp.getValue().getUserName().equals(name)) {
                        if (!(bootstrap.projectService.findAll().isEmpty())) {
                            System.out.println("PROJECTS:");
                            for (Map.Entry<String, Project> tmp1 : bootstrap.projectService.findAll().entrySet()) {
                                if (tmp1.getValue().getUserId().equals(tmp.getValue().getUserId())) {
                                    System.out.println(count + ". " + "PROJECT NAME:");
                                    System.out.println(tmp1.getValue().getName());
                                    count++;
                                }
                            }
                        } else if (!(bootstrap.taskService.findAll().isEmpty())) {
                            count = 1;
                            System.out.println("TASKS:");
                            for (Map.Entry<String, Task> tmp1 : bootstrap.taskService.findAll().entrySet()) {
                                if (tmp1.getValue().getUserId().equals(tmp.getValue().getUserId())) {
                                    System.out.println(count + ". " + "TASK NAME:");
                                    System.out.println(tmp1.getValue().getName());
                                    count++;
                                }
                            }
                        } else {
                            System.out.println("[EMPTY]");
                            System.out.println();
                        }
                        System.out.println();
                    }
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
