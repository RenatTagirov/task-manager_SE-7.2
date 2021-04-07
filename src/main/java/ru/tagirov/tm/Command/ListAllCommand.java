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
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "list-all";
    }

    @Override
    public String getDescription() {
        return "show all";
    }

    @Override
    public void execute() {
        if(!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[LIST ALL]");
            int count = 1;
            if (!(bootstrap.projectService.findAll().isEmpty())) {
                System.out.println("PROJECTS:");
                for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                    System.out.println(count + ". " + "PROJECT NAME:");
                    System.out.println(tmp.getValue().getName());
                    count++;
                }
            }else if(!(bootstrap.taskService.findAll().isEmpty())){
                count = 1;
                System.out.println("TASKS:");
                for (Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()) {
                    System.out.println(count + ". " + "TASK NAME:");
                    System.out.println(tmp.getValue().getName());
                    count++;
                }
            } else {
                System.out.println("[EMPTY]");
                System.out.println();
            }
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
