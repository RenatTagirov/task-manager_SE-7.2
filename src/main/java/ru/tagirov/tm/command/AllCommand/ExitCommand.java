package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "exit - account";
    }

    @Override
    public String getDescription() {
        return "log out of your profile";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
            Bootstrap.user = null;
            System.out.println();
        }else{
            System.out.println("[YOU ARE ALREADY LOGGED OUT OF YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}