package ru.tagirov.tm.Command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class AdminShowAllUsersCommand extends AbstractCommand {

    public AdminShowAllUsersCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "admin";
    }

    @Override
    public String getName() {
        return "all-user-show";
    }

    @Override
    public String getDescription() {
        return "show user";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
            System.out.println("[SHOW ALL PROFILE]");
            if (!(bootstrap.userService.findAll().isEmpty())){
                for (Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                    if (tmp.getValue().getDisplayName().equals("user")) {
                        System.out.println("Id: " + tmp.getValue().getUserId());
                        System.out.println("Name: " + tmp.getValue().getUserName());
                        System.out.println("Login: " + tmp.getValue().getLogin());
                        System.out.println("Password: " + tmp.getValue().getPassword());
                        System.out.println("Display name: " + tmp.getValue().getDisplayName());
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
