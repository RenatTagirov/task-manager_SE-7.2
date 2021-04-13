package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

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
        if(serviceLocator.getUser() == null){
            System.out.println("[LOGIN]");
            System.out.println("ENTER YOU LOGIN:");
            login = reader.readLine();
            System.out.println("ENTER YOU PASSWORD:");
            password = serviceLocator.getMd5().getMd5(reader.readLine());
            for (User tmp : serviceLocator.getIUserService().findAll()) {
                if (tmp.getLogin().equals(login) && tmp.getPassword().equals(password)) {
                    serviceLocator.setUser(tmp);
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
