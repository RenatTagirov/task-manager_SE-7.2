package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class UserShowProfileCommand extends AbstractCommand {

    public UserShowProfileCommand(){

    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "show profile";
    }

    @Override
    public String getDescription() {
        return "view your profile";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
            System.out.println("[SHOW PROFILE]");
            if(Bootstrap.user.getDateUpdate() == null){
                System.out.println("Name: " + Bootstrap.user.getName());
                System.out.println("Login: " + Bootstrap.user.getLogin());
                System.out.println("Display name: " + Bootstrap.user.getRole().getTitle());
                System.out.println("Date create: " + Bootstrap.user.getDateCreate());
                System.out.println();
            }else{
                System.out.println("Name: " + Bootstrap.user.getName());
                System.out.println("Login: " + Bootstrap.user.getLogin());
                System.out.println("Display name: " + Bootstrap.user.getRole().getTitle());
                System.out.println("Date create: " + Bootstrap.user.getDateCreate());
                System.out.println("Date update: " + Bootstrap.user.getDateUpdate());
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }

    }
}
