package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

public class ClearAllCommand extends AbstractCommand {


    public ClearAllCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "clear-all";
    }


    @Override
    public String getDescripion() {
        return "delete all";
    }

    @Override
    public void execute() {
        bootstrap.projectService.removeAll();
        bootstrap.taskService.removeAll();
        System.out.println("[OK]");
        System.out.println();
    }
}
