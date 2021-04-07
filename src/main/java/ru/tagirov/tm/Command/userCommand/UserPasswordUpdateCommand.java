package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class UserPasswordUpdateCommand extends AbstractCommand {

    public UserPasswordUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "password- update";
    }

    @Override
    public String getDescription() {
        return "change your password";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
                System.out.println("[PASSWORD UPDATE]");
                System.out.println("ENTER YOU OLD PASSWORD:");
                if((password = reader.readLine()).equals(bootstrap.user.getPassword())){
                    System.out.println("ENTER YOU NEW PASSWORD:");
                    newPassword = reader.readLine();
                    for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                        if(tmp.getValue().getUserId().equals(bootstrap.user.getUserId())){
                            tmp.getValue().setPassword(newPassword);
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
