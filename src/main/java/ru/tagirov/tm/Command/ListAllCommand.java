package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;

import java.util.Map;

public class ListAllCommand extends AbstractCommand {

    public ListAllCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "list-all";
    }

    @Override
    public String getDescripion() {
        return "show all";
    }

    @Override
    public void execute() {
        System.out.println("[LIST ALL]");
        int count = 1;
        if(!(bootstrap.projectService.findAll().isEmpty() && bootstrap.taskService.findAll().isEmpty())) {
            System.out.println("PROJECTS:");
            for(Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                System.out.println(count + ". " + "PROJECT NAME:");
                System.out.println(tmp.getValue().getName());
                count++;
            }
            count = 1;
            System.out.println("TASKS:");
            for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                System.out.println(count + ". " + "TASK NAME:");
                System.out.println(tmp.getValue().getName());
                count++;
            }
        }else {
            System.out.println("[EMPTY]");
            System.out.println();
        }
        System.out.println();
    }
}
