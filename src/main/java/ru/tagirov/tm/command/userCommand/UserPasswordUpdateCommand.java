package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserPasswordUpdateCommand extends AbstractCommand {

    public UserPasswordUpdateCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
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
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
                System.out.println("[PASSWORD UPDATE]");
                System.out.println("ENTER YOU OLD PASSWORD:");
                password = reader.readLine();
                bytes = md5.digest(password.getBytes());
                for (byte b : bytes) {
                builder.append(b);}
                if(builder.toString().equals(bootstrap.user.getPassword())){
                    System.out.println("ENTER YOU NEW PASSWORD:");
                    newPassword = reader.readLine();
                    newBytes = md5.digest(newPassword.getBytes());
                    for (byte b : newBytes) {
                        newBuilder.append(b);
                    }
                    for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                        if(tmp.getValue().getUserId().equals(bootstrap.user.getUserId())){
                            tmp.getValue().setPassword(newBuilder.toString());
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
