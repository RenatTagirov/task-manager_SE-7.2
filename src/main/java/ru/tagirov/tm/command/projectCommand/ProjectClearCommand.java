package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;

import java.util.Map;

public class ProjectClearCommand extends AbstractCommand {


    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
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
    public void execute() {
        if(!(bootstrap.user == null)) {
            System.out.println("[PROJECT CLEAR]");
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    bootstrap.projectService.remove(tmp.getValue());
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
