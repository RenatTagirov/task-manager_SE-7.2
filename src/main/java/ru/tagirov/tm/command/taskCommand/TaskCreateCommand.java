package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
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
    public void execute() throws IOException {
        if (!(bootstrap.user == null)) {
            System.out.println("[TASK CREATE]");
            System.out.println("ENTER NAME:");
            name = reader.readLine();
            System.out.println("ENTER DESCRIPTION:");
            description = reader.readLine();
            data = new Date();
            dateCreate = formatForDateNow.format(data);
            String id = UUID.randomUUID().toString();
            bootstrap.taskService.persist(new Task(id, name, description, dateCreate, bootstrap.user.getUserId()));
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
