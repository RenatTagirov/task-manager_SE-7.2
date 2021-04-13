package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.util.Map;

public class AdminShowAllUsersCommand extends AbstractCommand {

    public AdminShowAllUsersCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show all users";
    }

    @Override
    public String getDescription() {
        return "view all users";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(serviceLocator.getUser() == null)){
            System.out.println("[SHOW ALL PROFILE]");
            if (!(serviceLocator.getIUserService().findAll().isEmpty())){
                for (User tmp : serviceLocator.getIUserService().findAll()) {
                    if (tmp.getRole().getTitle().equals("user")) {
                        System.out.println("Id: " + tmp.getId());
                        System.out.println("Name: " + tmp.getName());
                        System.out.println("Login: " + tmp.getLogin());
                        System.out.println("Password: " + tmp.getPassword());
                        System.out.println("Display name: " + tmp.getRole().getTitle());
                        System.out.println("Date create: " + tmp.getDateCreate());
                        System.out.println("Date create: " + tmp.getDateUpdate());
                        System.out.println();
                    }
                }
            }else {
                System.out.println("[EMPTY!]");
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
