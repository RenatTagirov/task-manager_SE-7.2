package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class UserUpdateProfileCommand extends AbstractCommand {
    public UserUpdateProfileCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "update-profile";
    }

    @Override
    public String getDescription() {
        return "update your profile";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
            System.out.println("[UPDATE PROFILE]");
            System.out.println("WHAT YOU WANT TO UPDATE?");
            System.out.println("NAME OR LOGIN:");
            or = reader.readLine();
            if(or.equalsIgnoreCase("name") || or.equalsIgnoreCase("login")){
                if (or.equalsIgnoreCase("name")){
                    for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                        if(tmp.getValue().getUserId().equals(bootstrap.user.getUserId())){
                            System.out.println("ENTER NEW NAME:");
                            userName = reader.readLine();
                            tmp.getValue().setUserName(userName);
                            data = new Date();
                            tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                            bootstrap.user.setUserName(userName);
                            bootstrap.user.setDateUpdate(tmp.getValue().getDateUpdate());
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }if (or.equalsIgnoreCase("login")){
                    for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                        if(tmp.getValue().getUserId().equals(bootstrap.user.getUserId())){
                            System.out.println("ENTER NEW LOGIN:");
                            login= reader.readLine();
                            tmp.getValue().setLogin(login);
                            data = new Date();
                            tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                            bootstrap.user.setLogin(login);
                            bootstrap.user.setDateUpdate(tmp.getValue().getDateUpdate());
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
