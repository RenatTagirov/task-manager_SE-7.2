package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.util.Map;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "project update";
    }

    @Override
    public String getDescription() {
        return "edit the selected project";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(serviceLocator.getUser() == null)) {
            System.out.println("[PROJECT UPDATE]");
            System.out.println("ENTER PROJECT NAME:");
            name = reader.readLine();
            System.out.println("WHAT YOU WANT TO UPDATE?");
            System.out.println("NAME OR DESCRIPTION:");
            or = reader.readLine();
            if (or.equalsIgnoreCase("name")) {
                for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                    if (tmp.getName().equals(name) && tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                        System.out.println("ENTER NEW NAME:");
                        tmp.setName(reader.readLine());
                        tmp.setDateUpdate(serviceLocator.getDate().getDate());
                    }
                }
                System.out.println("[OK]");
                System.out.println();
            } else if (or.equalsIgnoreCase("description")) {
                for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                    if (tmp.getName().equals(name) && tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                        System.out.println("ENTER NEW DESCRIPTION:");
                        tmp.setDescription(reader.readLine());
                        tmp.setDateUpdate(serviceLocator.getDate().getDate());
                    }
                }
                System.out.println("[OK]");
                System.out.println();
            } else {
                System.out.println("[YOU COMMAND IS INVALID]");
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
