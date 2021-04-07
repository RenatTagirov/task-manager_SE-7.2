package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;

import java.io.IOException;

public class UserShowProfileCommand extends AbstractCommand {

    public UserShowProfileCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "show-profile";
    }

    @Override
    public String getDescription() {
        return "show your profile";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
            System.out.println("[SHOW PROFILE]");
            if(bootstrap.user.getDateCreate() == null){
                System.out.println("Name: " + bootstrap.user.getUserName());
                System.out.println("Login: " +bootstrap.user.getLogin());
                System.out.println("Display name: " + bootstrap.user.getDisplayName());
                System.out.println("Date create: " + bootstrap.user.getDateCreate());
                System.out.println();
            }else{
                System.out.println("Name: " + bootstrap.user.getUserName());
                System.out.println("Login: " + bootstrap.user.getLogin());
                System.out.println("Display name: " + bootstrap.user.getDisplayName());
                System.out.println("Date create: " + bootstrap.user.getDateCreate());
                System.out.println("Date create: " + bootstrap.user.getDateUpdate());
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }

    }
}
