package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;

import java.util.Map;

public class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task clear";
    }

    @Override
    public String getDescription() {
        return "delete all existing tasks";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() {
        if (!(Bootstrap.user == null)) {
            System.out.println("[TASK CLEAR]");
            for (Task tmp : serviceLocator.getITaskService().findAll()) {
                if (tmp.getUserId().equals(Bootstrap.user.getId())) {
                    serviceLocator.getITaskService().remove(tmp.getId());
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
