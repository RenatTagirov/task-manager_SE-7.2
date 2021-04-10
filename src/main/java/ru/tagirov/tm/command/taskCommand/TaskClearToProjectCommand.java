package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;
import java.util.Map;

public class TaskClearToProjectCommand extends AbstractCommand {

    public TaskClearToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task clear to project";
    }

    @Override
    public String getDescription() {
        return "delete all existing tasks in the project";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null)) {
            System.out.println("[TASK CLEAR TO PROJECT]");
            System.out.println("TASK PROJECT NAME:");
            nameProject = reader.readLine();
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameProject) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    bootstrap.projectService.remove(tmp.getValue());
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
