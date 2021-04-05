package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.util.Map;

public class TaskAddToProjectCommand extends AbstractCommand {

    public TaskAddToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-add-to-project";
    }

    @Override
    public String getDescripion() {
        return "add a task to the project";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[TASK ADD TO PROJECT]");
        System.out.println("ENTER TASK NAME:");
        nameTask = reader.readLine();
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        String id1 = null;
        String name1 = null;
        String description1 = null;
        String dateCreate1 = null;
        String id2 = null;
        Task task = null;
        for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameTask)) {
                id1 = tmp.getValue().getId();
                name1 = tmp.getValue().getName();
                description1 = tmp.getValue().getDescription();
                dateCreate1 = tmp.getValue().getDateCreate();
            }
        }
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)) {
                tmp.getValue().taskListToProject.add(new Task(id1, name1, description1, dateCreate1));
                id2 = tmp.getValue().getId();
            }
        }
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)) {
                for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)) {
                        tmp.getValue().taskListToProject.get(i).setIdProject(id2);
                    }
                }
            }
        }

        for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameTask)) {
                task = tmp.getValue();
            }
        }
        bootstrap.taskService.remove(task);
        System.out.println("[OK]");
        System.out.println();
    }
}
