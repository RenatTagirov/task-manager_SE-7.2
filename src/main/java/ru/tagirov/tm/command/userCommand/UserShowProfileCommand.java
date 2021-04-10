package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class UserShowProfileCommand extends AbstractCommand {

    public UserShowProfileCommand(Bootstrap bootstrap){
        super(bootstrap);
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
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[SHOW PROFILE]");
            if(bootstrap.user.getDateUpdate() == null){
                System.out.println("Name: " + bootstrap.user.getUserName());
                System.out.println("Login: " +bootstrap.user.getLogin());
                System.out.println("Display name: " + bootstrap.user.getRole().getTitle());
                System.out.println("Date create: " + bootstrap.user.getDateCreate());
                System.out.println();
            }else{
                System.out.println("Name: " + bootstrap.user.getUserName());
                System.out.println("Login: " + bootstrap.user.getLogin());
                System.out.println("Display name: " + bootstrap.user.getRole().getTitle());
                System.out.println("Date create: " + bootstrap.user.getDateCreate());
                System.out.println("Date update: " + bootstrap.user.getDateUpdate());
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }

    }
}
