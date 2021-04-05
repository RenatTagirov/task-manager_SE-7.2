package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Task;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "task-update";
    }

    @Override
    public String getDescripion() {
        return "update a task";
    }

    @Override
    public void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Date data;
        String or;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("[TASK UPDATE]");
        System.out.println("ENTER TASK NAME:");
        name = reader.readLine();
        System.out.println("WHAT YOU WANT TO UPDATE?");
        System.out.println("NAME OR DESCRIPTION:");
        or = reader.readLine();
        if (or.equalsIgnoreCase("name")){
            for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    tmp.getValue().setName(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                }
            }
        }else if(or.equalsIgnoreCase("description")){
            for(Map.Entry<String, Task> tmp : bootstrap.taskService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    tmp.getValue().setDescription(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                }
            }
        }
        System.out.println("[OK]");
        System.out.println();
    }
}
