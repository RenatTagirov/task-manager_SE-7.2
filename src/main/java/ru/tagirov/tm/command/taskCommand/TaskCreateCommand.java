package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand() {
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task create";
    }

    @Override
    public String getDescription() {
        return "create a new task";
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() throws IOException {
        if (!(serviceLocator.getUser() == null)) {
            System.out.println("[TASK CREATE]");
            System.out.println("ENTER NAME:");
            name = reader.readLine();
            System.out.println("ENTER DESCRIPTION:");
            description = reader.readLine();
            dateCreate = serviceLocator.getDate().getDate();
            id = serviceLocator.getUUID().getUuid();
            serviceLocator.getITaskService().persist(new Task(id, name, description, dateCreate, serviceLocator.getUser().getId()));
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
