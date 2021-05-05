package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.Md5Util;
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;

public class UserPasswordUpdateCommand extends AbstractCommand {

    public UserPasswordUpdateCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "update password";
    }

    @Override
    public String getDescription() {
        return "change your password";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }



    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
                System.out.println("[PASSWORD UPDATE]");
                System.out.println("ENTER YOU OLD PASSWORD:");
                password = Md5Util.getMd5(TerminalService.service());
                if(password.equals(Bootstrap.user.getPassword())){
                    System.out.println("ENTER YOU NEW PASSWORD:");
                    newPassword = Md5Util.getMd5(TerminalService.service());
                    for(User tmp : serviceLocator.getIUserService().findAll()){
                        if(tmp.getId().equals(Bootstrap.user.getId())){
                            tmp.setPassword(newPassword);
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }
                else if(password.equalsIgnoreCase("CANCEL")){
                    System.out.println("[YOU ENTER TO CANCEL]");
                    System.out.println();
                }else{
                    System.out.println("[YOU ENTERED THE WRONG PASSWORD!]");
                    System.out.println("TRY AGAIN, ENTER MORE OR CANCEL");
                    System.out.println();
                    execute();
                }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
