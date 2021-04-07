package ru.tagirov.tm.Command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import java.util.Map;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "task-list";
    }

    @Override
    public String getDescription() {
        return "show all task";
    }

    @Override
    public void execute() {
        if (!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[TASK LIST]");
            if (!(bootstrap.taskService.findAll().isEmpty())) {
                for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                    if (tmp.getValue().getDateUpdate() == null && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                        System.out.println("Task name: " + tmp.getValue().getName());
                        System.out.println("Task description: " + tmp.getValue().getDescription());
                        System.out.println("Date create: " + tmp.getValue().getDateCreate());
                        System.out.println();
                    } else {
                        System.out.println("Task name: " + tmp.getValue().getName());
                        System.out.println("Task description: " + tmp.getValue().getDescription());
                        System.out.println("Date create: " + tmp.getValue().getDateCreate());
                        System.out.println("Date update: " + tmp.getValue().getDateUpdate());
                        System.out.println();
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
