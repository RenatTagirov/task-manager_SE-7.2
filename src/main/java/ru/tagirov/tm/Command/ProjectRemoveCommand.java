package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "project-remove";
    }

    @Override
    public String getDescripion() {
        return "delete a project";
    }

    @Override
    public void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        System.out.println("[PROJECT REMOVE]");
        System.out.println("ENTER PROJECT NAME:");
        name = reader.readLine();
        Project project = null;
        for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(name)){
                project = tmp.getValue();
            }
        }
        bootstrap.projectService.remove(project);
        System.out.println("[OK]");
        System.out.println();
    }
}
