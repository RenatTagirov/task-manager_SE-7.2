package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserClearAllCommand extends AbstractCommand {

    public UserClearAllCommand(){
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "clear all";
    }


    @Override
    public String getDescription() {
        return "delete all projects and tasks";
    }


    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (Bootstrap.user == null) {
            if (Bootstrap.user.getRole().getTitle().equals("user")) {
                serviceLocator.getIProjectService().removeAll();
                serviceLocator.getITaskService().removeAll();
                System.out.println("[OK]");
                System.out.println();
            } else if (Bootstrap.user.getRole().getTitle().equals("admin")) {
                System.out.println("ENTER PROFILE NAME:");
                name = reader.readLine();
                for(User tmp : serviceLocator.getIUserService().findAll()){
                    if (tmp.getName().equals(name)){
                        for (Project tmp1 : serviceLocator.getIProjectService().findAll()) {
                            if (tmp1.getName().equals(name) && tmp1.getUserId().equals(Bootstrap.user.getId())) {
                                serviceLocator.getIProjectService().remove(tmp1.getId());
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
