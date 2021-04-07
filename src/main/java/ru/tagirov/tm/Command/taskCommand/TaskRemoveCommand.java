package ru.tagirov.tm.Command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.util.Map;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "task-remove";
    }

    @Override
    public String getDescription() {
        return "delete a task";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[TASK REMOVE]");
            System.out.println("ENTER TASK NAME:");
            Task task = null;
            for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(name) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId()))
                    bootstrap.taskService.remove(tmp.getValue());
            }
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
