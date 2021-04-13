package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class AdminShowProjectsToUserCommand extends AbstractCommand {

    public AdminShowProjectsToUserCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show projects user";
    }

    @Override
    public String getDescription() {
        return "view all user projects";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if(!(serviceLocator.getUser() == null)){
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(User tmp : serviceLocator.getIUserService().findAll()){
                if(tmp.getName().equals(name)){
                    for (Project tmp1 : serviceLocator.getIProjectService().findAll()) {
                        if (tmp1.getUserId().equals(tmp.getId())) {
                            if (tmp.getDateUpdate() == null) {
                                System.out.println("Project name:");
                                System.out.println(tmp1.getName());
                                System.out.println("Project description:");
                                System.out.println(tmp1.getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp1.getDateCreate());
                                System.out.println();
                            } else {
                                System.out.println("Project name:");
                                System.out.println(tmp1.getName());
                                System.out.println("Project description:");
                                System.out.println(tmp1.getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp1.getDateCreate());
                                System.out.println("Date update:");
                                System.out.println(tmp1.getDateUpdate());
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
