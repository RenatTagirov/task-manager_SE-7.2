package ru.tagirov.tm.command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Role;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class RegistrationCommand extends AbstractCommand {
    public RegistrationCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
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
                password = reader.readLine();
                bytes = md5.digest(password.getBytes());
                for (byte b : bytes){
                    builder.append(b);
                }
                data = new Date();
                dateCreate = formatForDateNow.format(data);
                id = UUID.randomUUID().toString();
                bootstrap.userService.persist(new User(id, userName, login, builder.toString(), bootstrap.role, dateCreate));
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
