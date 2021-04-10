package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LoginCommand extends AbstractCommand {
    public LoginCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "log in to your profile";
    }

    @Override
    public void execute() throws IOException {
        if(bootstrap.user == null){
            System.out.println("[LOGIN]");
            System.out.println("ENTER YOU LOGIN:");
            login = reader.readLine();
            System.out.println("ENTER YOU PASSWORD:");
            password = bootstrap.md5.getMd5(reader.readLine());
            for (Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()) {
                if (tmp.getValue().getLogin().equals(login) && tmp.getValue().getPassword().equals(password)) {
                    bootstrap.user = tmp.getValue();
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                }
            }
        }else{
            System.out.println("[YOU HAVE ALREADY LOGGED IN!]");
            System.out.println();
        }
    }

}
