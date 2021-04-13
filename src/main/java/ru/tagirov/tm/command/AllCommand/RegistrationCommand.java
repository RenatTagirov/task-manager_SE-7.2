package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.enumeration.Role;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class RegistrationCommand extends AbstractCommand {

    public RegistrationCommand() {
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
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (serviceLocator.getUser() == null) {
            System.out.println("[REGISTRATION]");
            System.out.println("YOU USER OR ADMIN?");
            enterRole = reader.readLine();
            if (enterRole.equalsIgnoreCase("user") || enterRole.equalsIgnoreCase("admin")){
                for (Role value : Role.values()) {
                    if (value.getTitle().equalsIgnoreCase(enterRole)) {
                        serviceLocator.setRole(value);
                        break;
                    }
                }
                System.out.println("ENTER NAME:");
                userName = reader.readLine();
                System.out.println("ENTER LOGIN:");
                login = reader.readLine();
                System.out.println("ENTER PASSWORD:");
                password = serviceLocator.getMd5().getMd5(reader.readLine());
                dateCreate = serviceLocator.getDate().getDate();
                id = serviceLocator.getUUID().getUuid();
                serviceLocator.getIUserService().persist(new User(id, userName, login, password, serviceLocator.getRole(), dateCreate));
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
