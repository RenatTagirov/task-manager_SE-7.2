package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        String name = "task-create";
        return name;
    }

    @Override
    public String getDescripion() {
        String descripion = "create a new task";
        return descripion;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        name = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        bootstrap.taskService.persist(new Task(id, name, description, dateCreate));
        System.out.println("[OK]");
        System.out.println();
    }
}
