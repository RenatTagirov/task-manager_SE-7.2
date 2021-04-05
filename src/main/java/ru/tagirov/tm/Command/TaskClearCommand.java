package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

public class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-clear";
    }

    @Override
    public String getDescripion() {
        return "delete all task";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CLEAR]");
        bootstrap.taskService.removeAll();
        System.out.println("[OK]");
        System.out.println();
    }
}
