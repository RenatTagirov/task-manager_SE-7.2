package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class AdminShowAllUsersCommand extends AbstractCommand {

    public AdminShowAllUsersCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
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
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[SHOW ALL PROFILE]");
            if (!(bootstrap.userService.findAll().isEmpty())){
                for (Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                    if (tmp.getValue().getRole().getTitle().equals("user")) {
                        System.out.println("Id: " + tmp.getValue().getUserId());
                        System.out.println("Name: " + tmp.getValue().getUserName());
                        System.out.println("Login: " + tmp.getValue().getLogin());
                        System.out.println("Password: " + tmp.getValue().getPassword());
                        System.out.println("Display name: " + tmp.getValue().getRole().getTitle());
                        System.out.println("Date create: " + tmp.getValue().getDateCreate());
                        System.out.println("Date create: " + tmp.getValue().getDateUpdate());
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
