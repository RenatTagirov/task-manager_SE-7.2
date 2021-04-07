package ru.tagirov.tm.Command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;

import java.util.Date;
import java.util.Map;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "task-update";
    }

    @Override
    public String getDescription() {
        return "update a task";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[TASK UPDATE]");
            System.out.println("ENTER TASK NAME:");
            name = reader.readLine();
            System.out.println("WHAT YOU WANT TO UPDATE?");
            System.out.println("NAME OR DESCRIPTION:");
            or = reader.readLine();
            if (or.equalsIgnoreCase("name")) {
                for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                    if (tmp.getValue().getName().equals(name) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                        System.out.println("ENTER NEW NAME:");
                        tmp.getValue().setName(reader.readLine());
                        data = new Date();
                        tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                    }
                }
            } else if (or.equalsIgnoreCase("description")) {
                for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                    if (tmp.getValue().getName().equals(name) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                        System.out.println("ENTER NEW DESCRIPTION:");
                        tmp.getValue().setDescription(reader.readLine());
                        data = new Date();
                        tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                    }
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
