package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;
import java.util.Map;

public class TaskClearToProjectCommand extends AbstractCommand {

    public TaskClearToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-clear-to-project";
    }

    @Override
    public String getDescripion() {
        return "delete all task in the project";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[TASK CLEAR TO PROJECT]");
        System.out.println("TASK PROJECT NAME:");
        Project project = null;
        nameProject = reader.readLine();
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
            if (tmp.getValue().getName().equals(nameProject)){
                project = tmp.getValue();
            }
        }
        bootstrap.projectService.findOne(project).taskListToProject.clear();
        System.out.println("[OK]");
        System.out.println();
    }
}
