package ru.tagirov.tm.Command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Task;

import java.util.Map;

public class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "task-clear";
    }

    @Override
    public String getDescription() {
        return "delete all task";
    }

    @Override
    public void execute() {
        if (!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[TASK CLEAR]");
            for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                if (tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    bootstrap.taskService.remove(tmp.getValue());
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
