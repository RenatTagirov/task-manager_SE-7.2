package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

public class HelpCommand extends AbstractCommand {


    public HelpCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Show all commands";
    }

    @Override
    public void execute() {
        System.out.println("project-create - create a new project");
        System.out.println("project-update - update a project");
        System.out.println("project-list - show all project");
        System.out.println("project-remove - delete a project");
        System.out.println("project-clear - delete all project");
        System.out.println("task-create - create a new task");
        System.out.println("task-create-to-project - create a new task in the project");
        System.out.println("task-update - update a task");
        System.out.println("task-update-to-project - update a task in the project");
        System.out.println("task-list - show all task");
        System.out.println("task-list-to-project - show all task in the project");
        System.out.println("task-remove - delete a task");
        System.out.println("task-remove-to-project - delete a task in the project.");
        System.out.println("task-clear - delete all task");
        System.out.println("task-clear-to-project - delete all task in the project");
        System.out.println("task-add-to-project - add a task to the project");
        System.out.println("list-all - show all");
        System.out.println("clear-all - delete all");
        System.out.println("help - Show all commands");
    }
}
