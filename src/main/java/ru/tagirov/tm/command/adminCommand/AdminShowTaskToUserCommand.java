package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class AdminShowTaskToUserCommand extends AbstractCommand {

    public AdminShowTaskToUserCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show tasks user";
    }

    @Override
    public String getDescription() {
        return "view all user tasks";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(serviceLocator.getUser() == null)){
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(User tmp : serviceLocator.getIUserService().findAll()){
                if(tmp.getName().equals(name)){
                    for (Task tmp1 : serviceLocator.getITaskService().findAll()) {
                        if (tmp1.getUserId().equals(tmp.getId())) {
                            if (tmp1.getDateUpdate() == null) {
                                System.out.println("Task name: " + tmp1.getName());
                                System.out.println("Task description: " + tmp1.getDescription());
                                System.out.println("Date create: " + tmp1.getDateCreate());
                                System.out.println();
                            }else {
                                System.out.println("Task name: " + tmp1.getName());
                                System.out.println("Task description: " + tmp1.getDescription());
                                System.out.println("Date create: " + tmp1.getDateCreate());
                                System.out.println("Date update: " + tmp1.getDateUpdate());
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
