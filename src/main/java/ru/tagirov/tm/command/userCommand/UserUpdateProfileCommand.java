package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

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
        if(!(serviceLocator.getUser() == null)){
            System.out.println("[UPDATE PROFILE]");
            System.out.println("WHAT YOU WANT TO UPDATE?");
            System.out.println("NAME OR LOGIN:");
            or = reader.readLine();
            if(or.equalsIgnoreCase("name") || or.equalsIgnoreCase("login")){
                if (or.equalsIgnoreCase("name")){
                    for(User tmp : serviceLocator.getIUserService().findAll()){
                        if(tmp.getId().equals(serviceLocator.getUser().getId())){
                            System.out.println("ENTER NEW NAME:");
                            userName = reader.readLine();
                            tmp.setName(userName);
                            tmp.setDateUpdate(serviceLocator.getDate().getDate());
                            serviceLocator.getUser().setName(userName);
                            serviceLocator.getUser().setDateUpdate(tmp.getDateUpdate());
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }if (or.equalsIgnoreCase("login")){
                    for(User tmp : serviceLocator.getIUserService().findAll()){
                        if(tmp.getId().equals(serviceLocator.getUser().getId())){
                            System.out.println("ENTER NEW LOGIN:");
                            login= reader.readLine();
                            tmp.setLogin(login);
                            tmp.setDateUpdate(serviceLocator.getDate().getDate());
                            serviceLocator.getUser().setLogin(login);
                            serviceLocator.getUser().setDateUpdate(tmp.getDateUpdate());
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
