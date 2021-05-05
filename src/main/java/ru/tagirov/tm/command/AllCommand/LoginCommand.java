package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.Md5Util;
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;

public class LoginCommand extends AbstractCommand {

    public LoginCommand() {
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
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(Bootstrap.user == null){
            System.out.println("[LOGIN]");
            System.out.println("ENTER YOU LOGIN:");
            login = TerminalService.service();
            System.out.println("ENTER YOU PASSWORD:");
            password = Md5Util.getMd5(TerminalService.service());
            for (User tmp : serviceLocator.getIUserService().findAll()) {
                if (tmp.getLogin().equals(login) && tmp.getPassword().equals(password)) {
                    Bootstrap.user = tmp;
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
