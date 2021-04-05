package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.util.Map;

public class TaskRemoveCommand extends AbstractCommand {
    public TaskRemoveCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-remove";
    }

    @Override
    public String getDescripion() {
        return "delete a task";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[TASK REMOVE]");
        System.out.println("ENTER TASK NAME:");
        Task task = null;
        name = reader.readLine();
        for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
            if(tmp.getValue().getName().equals(name))
                task = tmp.getValue();
        }
        bootstrap.taskService.remove(task);
        System.out.println("[OK]");
        System.out.println();
    }
}
