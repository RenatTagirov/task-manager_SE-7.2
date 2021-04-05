package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

public class ProjectClearCommand extends AbstractCommand {


    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "project-clear";
    }

    @Override
    public String getDescripion() {
        return "delete all project";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        bootstrap.projectService.removeAll();
        System.out.println("[OK]");
        System.out.println();
    }
}
