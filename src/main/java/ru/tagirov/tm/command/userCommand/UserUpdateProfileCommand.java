package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class UserUpdateProfileCommand extends AbstractCommand {
    public UserUpdateProfileCommand(){

    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "update profile";
    }

    @Override
    public String getDescription() {
        return "change your profile";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void execute() throws IOException {
        if(!(Bootstrap.user == null)){
            System.out.println("[UPDATE PROFILE]");
            System.out.println("WHAT YOU WANT TO UPDATE?");
            System.out.println("NAME OR LOGIN:");
            or = TerminalService.service();
            if(or.equalsIgnoreCase("name") || or.equalsIgnoreCase("login")){
                if (or.equalsIgnoreCase("name")){
                    for(User tmp : serviceLocator.getIUserService().findAll()){
                        if(tmp.getId().equals(Bootstrap.user.getId())){
                            System.out.println("ENTER NEW NAME:");
                            userName = TerminalService.service();
                            tmp.setName(userName);
                            tmp.setDateUpdate(DateUtil.getDate());
                            Bootstrap.user.setName(userName);
                            Bootstrap.user.setDateUpdate(tmp.getDateUpdate());
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }if (or.equalsIgnoreCase("login")){
                    for(User tmp : serviceLocator.getIUserService().findAll()){
                        if(tmp.getId().equals(Bootstrap.user.getId())){
                            System.out.println("ENTER NEW LOGIN:");
                            login= TerminalService.service();
                            tmp.setLogin(login);
                            tmp.setDateUpdate(DateUtil.getDate());
                            Bootstrap.user.setLogin(login);
                            Bootstrap.user.setDateUpdate(tmp.getDateUpdate());
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }
            }
            else if(or.equalsIgnoreCase("CANCEL")){
                System.out.println("[YOU ENTER TO CANCEL]");
                System.out.println();
            }else{
                System.out.println("[YOU ENTERED THE WRONG VALUE!]");
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
