package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.ServiceLocator;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "project list";
    }

    @Override
    public String getDescription() {
        return "view all available projects";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() {
        if(!(Bootstrap.user == null)) {
            System.out.println("[PROJECT LIST]");
            if (!(serviceLocator.getIProjectService().findAll().isEmpty())) {
                for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                    if (tmp.getUserId().equals(Bootstrap.user.getId())) {
                        if (tmp.getDateUpdate() == null) {
                            System.out.println("Project name:");
                            System.out.println(tmp.getName());
                            System.out.println("Project description:");
                            System.out.println(tmp.getDescription());
                            System.out.println("Date create:");
                            System.out.println(tmp.getDateCreate());
                            System.out.println();
                        } else {
                            System.out.println("Project name:");
                            System.out.println(tmp.getName());
                            System.out.println("Project description:");
                            System.out.println(tmp.getDescription());
                            System.out.println("Date create:");
                            System.out.println(tmp.getDateCreate());
                            System.out.println("Date update:");
                            System.out.println(tmp.getDateUpdate());
                            System.out.println();
                        }
                    }
                }
            } else {
                System.out.println("[EMPTY]");
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
