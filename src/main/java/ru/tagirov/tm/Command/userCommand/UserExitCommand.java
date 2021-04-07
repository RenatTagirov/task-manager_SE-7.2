package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;

import java.io.IOException;

public class UserExitCommand extends AbstractCommand {

    public UserExitCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "exit - account";
    }

    @Override
    public String getDescription() {
        return "exit from account";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
            bootstrap.user = null;
            bootstrap.admin = null;
            System.out.println();
        }else{
            System.out.println("[YOU ARE ALREADY LOGGED OUT OF YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}