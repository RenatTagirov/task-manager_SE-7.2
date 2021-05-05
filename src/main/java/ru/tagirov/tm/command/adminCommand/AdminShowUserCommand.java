package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;
import java.util.Map;

public class AdminShowUserCommand extends AbstractCommand {

    public AdminShowUserCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show user";
    }

    @Override
    public String getDescription() {
        return "view user";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
            System.out.println("[SHOW PROFILE]");
            System.out.println("[ENTER NAME PROFILE]");
            name = TerminalService.service();
            for(User tmp : serviceLocator.getIUserService().findAll()){
                if(tmp.getName().equals(name)){
                    if(tmp.getDateCreate() == null){
                        System.out.println("Name: " + tmp.getId());
                        System.out.println("Name: " + tmp.getName());
                        System.out.println("Login: " + tmp.getLogin());
                        System.out.println("Login: " + tmp.getPassword());
                        System.out.println("Display name: " + tmp.getRole().getTitle());
                        System.out.println("Date create: " + tmp.getDateCreate());
                        System.out.println();
                    }else{
                        System.out.println("Name: " + tmp.getId());
                        System.out.println("Name: " + tmp.getName());
                        System.out.println("Login: " + tmp.getLogin());
                        System.out.println("Login: " + tmp.getPassword());
                        System.out.println("Display name: " + tmp.getRole().getTitle());
                        System.out.println("Date create: " + tmp.getDateCreate());
                        System.out.println("Date create: " + tmp.getDateUpdate());
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
