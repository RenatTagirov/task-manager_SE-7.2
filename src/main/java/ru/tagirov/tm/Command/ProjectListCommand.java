package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import java.util.Map;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "project-list";
    }

    @Override
    public String getDescripion() {
        return "show all project";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT LIST]");
        if(!(bootstrap.projectService.findAll().isEmpty())){
            for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()){
                if (tmp.getValue().getDateUpdate() == null){
                    System.out.println("Project name:");
                    System.out.println(tmp.getValue().getName());
                    System.out.println("Project description:");
                    System.out.println(tmp.getValue().getDescription());
                    System.out.println("Date create:");
                    System.out.println(tmp.getValue().getDateCreate());
                    System.out.println();
                }else {
                    System.out.println("Project name:");
                    System.out.println(tmp.getValue().getName());
                    System.out.println("Project description:");
                    System.out.println(tmp.getValue().getDescription());
                    System.out.println("Date create:");
                    System.out.println(tmp.getValue().getDateCreate());
                    System.out.println("Date update:");
                    System.out.println(tmp.getValue().getDateUpdate());
                    System.out.println();
                }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }
    }
}
