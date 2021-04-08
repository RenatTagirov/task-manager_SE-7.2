package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class AdminRemoveToUserCommand extends AbstractCommand {

    public AdminRemoveToUserCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
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
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[USER REMOVE]");
            System.out.println("ENTER USER NAME:");
            name = reader.readLine();
            for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                if (tmp.getValue().getUserName().equals(name)){
                    bootstrap.userService.remove(tmp.getValue());
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
