package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class AdminRemoveToUserCommand extends AbstractCommand {

    public AdminRemoveToUserCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "remove user";
    }

    @Override
    public String getDescription() {
        return "delete a user";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
            System.out.println("[USER REMOVE]");
            System.out.println("ENTER USER NAME:");
            name = reader.readLine();
            for(User tmp : serviceLocator.getIUserService().findAll()){
                if (tmp.getName().equals(name)){
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
