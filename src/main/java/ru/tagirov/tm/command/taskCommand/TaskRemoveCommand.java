package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;
import java.util.Map;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task remove";
    }

    @Override
    public String getDescription() {
        return "delete the selected task";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[TASK REMOVE]");
            System.out.println("ENTER TASK NAME:");
            Task task = null;
            for (Task tmp : serviceLocator.getITaskService().findAll()) {
                if (tmp.getName().equals(name) && tmp.getUserId().equals(serviceLocator.getUser().getId()))
                    serviceLocator.getITaskService().remove(tmp.getId());
            }
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
