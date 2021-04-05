package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class TaskListToProjectCommand extends AbstractCommand {

    public TaskListToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-list-to-project";
    }

    @Override
    public String getDescripion() {
        return "show all task in the project";
    }

    @Override
    public void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameProject;
        System.out.println("[TASK LIST TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        int count = 1;
        if(!(bootstrap.projectService.findAll().isEmpty())){
            for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
                if (!(tmp.getValue().taskListToProject.isEmpty())) {
                    if (tmp.getValue().getName().equals(nameProject)) {
                        for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                            if (tmp.getValue().taskListToProject.get(i).getDateUpdate() == null) {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateCreate());
                                System.out.println();
                                count++;
                            } else {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateCreate());
                                System.out.println("Date update:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateUpdate());
                                System.out.println();
                                count++;
                            }
                        }
                    }
                } else {
                    System.out.println("[EMPTY]");
                    System.out.println();
                }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }
    }
}
