package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TaskUpdateToProjectCommand extends AbstractCommand {

    public TaskUpdateToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-update-to-project";
    }

    @Override
    public String getDescripion() {
        return "update a task in the project";
    }

    @Override
    public void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date data;
        String or;
        String nameTask;
        String nameProject;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("[TASK UPDATE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)){
                System.out.println("ENTER TASK NAME:");
                nameTask = reader.readLine();
                for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++){
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)){
                        System.out.println("WHAT YOU WANT TO UPDATE?");
                        System.out.println("NAME OR DESCRIPTION:");
                        or = reader.readLine();
                        if (or.equalsIgnoreCase("name")){
                            System.out.println("ENTER NEW NAME:");
                            tmp.getValue().taskListToProject.get(i).setName(reader.readLine());
                            data = new Date();
                            tmp.getValue().taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                        else if(or.equalsIgnoreCase("description")){
                            System.out.println("ENTER NEW DESCRIPTION:");
                            tmp.getValue().taskListToProject.get(i).setDescription(reader.readLine());
                            data = new Date();
                            tmp.getValue().taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
