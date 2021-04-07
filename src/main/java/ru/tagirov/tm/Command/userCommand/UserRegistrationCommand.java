package ru.tagirov.tm.Command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class UserRegistrationCommand extends AbstractCommand {
    public UserRegistrationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "registration";
    }

    @Override
    public String getDescription() {
        return "create a new account";
    }

    @Override
    public void execute() throws IOException {
        if (bootstrap.user == null && bootstrap.admin == null) {
            System.out.println("[REGISTRATION]");
            System.out.println("YOU USER OR ADMIN?");
                displayName = reader.readLine();
                if (displayName.equalsIgnoreCase("user") || displayName.equalsIgnoreCase("admin")){
                    System.out.println("ENTER NAME:");
                    userName = reader.readLine();
                    System.out.println("ENTER LOGIN:");
                    login = reader.readLine();
                    System.out.println("ENTER PASSWORD:");
                    password = reader.readLine();
                    data = new Date();
                    dateCreate = formatForDateNow.format(data);
                    id = UUID.randomUUID().toString();
                    bootstrap.userService.persist(new User(id, userName, login, password, displayName, dateCreate));
                    System.out.println("[OK]");
                    System.out.println();
                }
                else if(displayName.equalsIgnoreCase("CANCEL")){
                    System.out.println("[YOU ENTER TO CANCEL]");
                    System.out.println();
                }else {
                    System.out.println("[YOU ENTERED THE WRONG VALUE!]");
                    System.out.println("TRY AGAIN, ENTER MORE OR CANCEL");
                    execute();
                }
        } else {
            System.out.println("[YOU'RE ALREADY LOGGER IN!]");
            System.out.println();
        }
    }
}
