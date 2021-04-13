package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.init.ServiceLocator;

public class ProjectClearCommand extends AbstractCommand {


    public ProjectClearCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "project clear";
    }

    @Override
    public String getDescription() {
        return "delete all existing projects";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() {
        if(!(serviceLocator.getUser() == null)) {
            System.out.println("[PROJECT CLEAR]");
            for (Project tmp : serviceLocator.getIProjectService().findAll()) {
                if (tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                    serviceLocator.getIProjectService().remove(tmp.getId());
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
