package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task list";
    }

    @Override
    public String getDescription() {
        return "view all available tasks";
    }

    @Override
    public void execute() {
        if (!(bootstrap.user == null)) {
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
