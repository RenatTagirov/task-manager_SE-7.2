package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserListAllCommand extends AbstractCommand {

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
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void execute() throws IOException {
        if(!(serviceLocator.getUser() == null)) {
            System.out.println("[LIST ALL]");
            int count = 1;
            if (serviceLocator.getUser().getRole().getTitle().equals("user")) {
                if (!(serviceLocator.getIProjectService().findAll().isEmpty())) {
                    System.out.println("PROJECTS:");
                    for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                        System.out.println(count + ". " + "PROJECT NAME:");
                        System.out.println(tmp.getName());
                        count++;
                    }
                } else if (!(serviceLocator.getITaskService().findAll().isEmpty())) {
                    count = 1;
                    System.out.println("TASKS:");
                    for (Task tmp : serviceLocator.getITaskService().findAll()) {
                        System.out.println(count + ". " + "TASK NAME:");
                        System.out.println(tmp.getName());
                        count++;
                    }
                } else {
                    System.out.println("[EMPTY]");
                    System.out.println();
                }
                System.out.println();
            }else if (serviceLocator.getUser().getRole().getTitle().equals("admin")) {
                System.out.println("ENTER PROFILE NAME:");
                name = reader.readLine();
                for(User tmp : serviceLocator.getIUserService().findAll()) {
                    if (tmp.getName().equals(name)) {
                        if (!(serviceLocator.getIProjectService().findAll().isEmpty())) {
                            System.out.println("PROJECTS:");
                            for (Project tmp1 : serviceLocator.getIProjectService().findAll()) {
                                if (tmp1.getUserId().equals(tmp.getId())) {
                                    System.out.println(count + ". " + "PROJECT NAME:");
                                    System.out.println(tmp1.getName());
                                    count++;
                                }
                            }
                        } else if (!(serviceLocator.getITaskService().findAll().isEmpty())) {
                            count = 1;
                            System.out.println("TASKS:");
                            for (Task tmp1 : serviceLocator.getITaskService().findAll()) {
                                if (tmp1.getUserId().equals(tmp.getId())) {
                                    System.out.println(count + ". " + "TASK NAME:");
                                    System.out.println(tmp1.getName());
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
