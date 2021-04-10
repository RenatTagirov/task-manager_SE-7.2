package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.Role;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Date;

public class RegistrationCommand extends AbstractCommand {
    public RegistrationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "registration";
    }

    @Override
    public String getDescription() {
        return "register a new user";
    }

    @Override
    public void execute() throws IOException {
        if (bootstrap.user == null) {
            System.out.println("[REGISTRATION]");
            System.out.println("YOU USER OR ADMIN?");
            enterRole = reader.readLine();
            if (enterRole.equalsIgnoreCase("user") || enterRole.equalsIgnoreCase("admin")){
                for (Role value : Role.values()) {
                    if (value.getTitle().equalsIgnoreCase(enterRole)) {
                        bootstrap.role = value;
                        break;
                    }
                }
                System.out.println("ENTER NAME:");
                userName = reader.readLine();
                System.out.println("ENTER LOGIN:");
                login = reader.readLine();
                System.out.println("ENTER PASSWORD:");
                password = bootstrap.md5.getMd5(reader.readLine());
                dateCreate = bootstrap.getDate.getDate();
                id = bootstrap.uuid.getUuid();
                bootstrap.userService.persist(new User(id, userName, login, password, bootstrap.role, dateCreate));
                System.out.println("[OK]");
                System.out.println();
            }
            else if(enterRole.equalsIgnoreCase("CANCEL")){
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
