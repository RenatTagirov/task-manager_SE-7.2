package ru.tagirov.tm.Command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class TaskCreateToProjectCommand extends AbstractCommand {

    public TaskCreateToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "task-create-to-project";
    }

    @Override
    public String getDescription() {
        return "create a new task in the project";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[TASK CREATE TO PROJECT]");
            System.out.println("ENTER PROJECT NAME:");
            nameProject = reader.readLine();
            System.out.println("ENTER NAME:");
            nameTask = reader.readLine();
            System.out.println("ENTER DESCRIPTION:");
            description = reader.readLine();
            data = new Date();
            dateCreate = formatForDateNow.format(data);
            String id = UUID.randomUUID().toString();
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameProject) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    tmp.getValue().taskListToProject.add(new Task(id, nameTask, description, dateCreate, bootstrap.user.getUserId()));
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
