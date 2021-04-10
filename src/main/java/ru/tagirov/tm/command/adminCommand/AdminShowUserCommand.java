package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class AdminShowUserCommand extends AbstractCommand {

    public AdminShowUserCommand(Bootstrap bootstrap) {
        super(bootstrap);
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
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[SHOW PROFILE]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                if(tmp.getValue().getUserName().equals(name)){
                    if(tmp.getValue().getDateCreate() == null){
                        System.out.println("Name: " + tmp.getValue().getUserId());
                        System.out.println("Name: " + tmp.getValue().getUserName());
                        System.out.println("Login: " + tmp.getValue().getLogin());
                        System.out.println("Login: " + tmp.getValue().getPassword());
                        System.out.println("Display name: " + tmp.getValue().getRole().getTitle());
                        System.out.println("Date create: " + tmp.getValue().getDateCreate());
                        System.out.println();
                    }else{
                        System.out.println("Name: " + tmp.getValue().getUserId());
                        System.out.println("Name: " + tmp.getValue().getUserName());
                        System.out.println("Login: " + tmp.getValue().getLogin());
                        System.out.println("Login: " + tmp.getValue().getPassword());
                        System.out.println("Display name: " + tmp.getValue().getRole().getTitle());
                        System.out.println("Date create: " + tmp.getValue().getDateCreate());
                        System.out.println("Date create: " + tmp.getValue().getDateUpdate());
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
