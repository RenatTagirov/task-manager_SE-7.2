package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class TaskAddToProjectCommand extends AbstractCommand {

    public TaskAddToProjectCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task add to project";
    }

    @Override
    public String getDescription() {
        return "move the selected task to the project";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null)) {
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
            for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameTask) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    id1 = tmp.getValue().getId();
                    name1 = tmp.getValue().getName();
                    description1 = tmp.getValue().getDescription();
                    dateCreate1 = tmp.getValue().getDateCreate();
                }
            }
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameProject) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    tmp.getValue().taskListToProject.add(new Task(id1, name1, description1, dateCreate1, bootstrap.user.getUserId()));
                    id2 = tmp.getValue().getId();
                }
            }
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameProject) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                        if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)) {
                            tmp.getValue().taskListToProject.get(i).setIdProject(id2);
                        }
                    }
                }
            }

            for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameTask) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
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
