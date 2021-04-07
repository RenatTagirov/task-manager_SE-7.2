package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class UserLoginCommand extends AbstractCommand {
    public UserLoginCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "log in to your task manager";
    }

    @Override
    public void execute() throws IOException {
        if(bootstrap.user == null && bootstrap.admin == null){
            System.out.println("[LOGIN]");
            System.out.println("ENTER YOU LOGIN:");
            login = reader.readLine();
            System.out.println("ENTER YOU PASSWORD:");
            password = reader.readLine();
            for (Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                if (tmp.getValue().getLogin().equals(login) && tmp.getValue().getPassword().equals(password)) {
                    if (tmp.getValue().getDisplayName().equals("admin")) {
                        bootstrap.admin = tmp.getValue();
                        System.out.println("[OK]");
                        System.out.println();
                        break;
                    } else {
                        bootstrap.user = tmp.getValue();
                        System.out.println("[OK]");
                        System.out.println();
                        break;
                    }
                }
            }
        }else{
            System.out.println("[YOU HAVE ALREADY LOGGED IN!]");
            System.out.println();
        }
    }

}
