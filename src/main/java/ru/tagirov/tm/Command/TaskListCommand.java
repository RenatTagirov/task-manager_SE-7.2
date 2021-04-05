package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Task;
import java.util.Map;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-list";
    }

    @Override
    public String getDescripion() {
        return "show all task";
    }

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        if(!(bootstrap.taskService.findAll().isEmpty())){
            for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
                if (tmp.getValue().getDateUpdate() == null){
                    System.out.println("Task name: " + tmp.getValue().getName());
                    System.out.println("Task description: " + tmp.getValue().getDescription());
                    System.out.println("Date create: " + tmp.getValue().getDateCreate());
                    System.out.println();
                }else {
                    System.out.println("Task name: " + tmp.getValue().getName());
                    System.out.println("Task description: " + tmp.getValue().getDescription());
                    System.out.println("Date create: " + tmp.getValue().getDateCreate());
                    System.out.println("Date update: " + tmp.getValue().getDateUpdate());
                    System.out.println();
                }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }
    }
}
