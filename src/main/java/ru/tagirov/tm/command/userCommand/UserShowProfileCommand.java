package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
        if(!(serviceLocator.getUser() == null)){
            System.out.println("[SHOW PROFILE]");
            if(serviceLocator.getUser().getDateUpdate() == null){
                System.out.println("Name: " + serviceLocator.getUser().getName());
                System.out.println("Login: " + serviceLocator.getUser().getLogin());
                System.out.println("Display name: " + serviceLocator.getUser().getRole().getTitle());
                System.out.println("Date create: " + serviceLocator.getUser().getDateCreate());
                System.out.println();
            }else{
                System.out.println("Name: " + serviceLocator.getUser().getName());
                System.out.println("Login: " + serviceLocator.getUser().getLogin());
                System.out.println("Display name: " + serviceLocator.getUser().getRole().getTitle());
                System.out.println("Date create: " + serviceLocator.getUser().getDateCreate());
                System.out.println("Date update: " + serviceLocator.getUser().getDateUpdate());
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }

    }
}
