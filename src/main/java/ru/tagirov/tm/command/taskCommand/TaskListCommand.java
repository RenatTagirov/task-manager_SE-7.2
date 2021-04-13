package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;

import java.util.Map;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task list";
    }

    @Override
    public String getDescription() {
        return "view all available tasks";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[TASK LIST]");
            if (!(serviceLocator.getITaskService().findAll().isEmpty())) {
                for (Task tmp : serviceLocator.getITaskService().findAll()) {
                    if (tmp.getDateUpdate() == null && tmp.getUserId().equals(serviceLocator.getUser().getId())) {
                        System.out.println("Task name: " + tmp.getName());
                        System.out.println("Task description: " + tmp.getDescription());
                        System.out.println("Date create: " + tmp.getDateCreate());
                        System.out.println();
                    } else {
                        System.out.println("Task name: " + tmp.getName());
                        System.out.println("Task description: " + tmp.getDescription());
                        System.out.println("Date create: " + tmp.getDateCreate());
                        System.out.println("Date update: " + tmp.getDateUpdate());
                        System.out.println();
                    }
                }
            } else {
                System.out.println("[EMPTY]");
                System.out.println();
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
