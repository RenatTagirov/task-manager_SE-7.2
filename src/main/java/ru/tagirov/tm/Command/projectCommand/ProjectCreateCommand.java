package ru.tagirov.tm.Command.projectCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "user";
    }

    @Override
    public String getName() {
        return "project-create";
    }

    @Override
    public String getDescription() {
        return "create a new project";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)) {
            System.out.println("[PROJECT CREATE]");
            System.out.println("ENTER NAME:");
            nameProject = reader.readLine();
            System.out.println("ENTER DESCRIPTION:");
            description = reader.readLine();
            data = new Date();
            dateCreate = formatForDateNow.format(data);
            String id = UUID.randomUUID().toString();
            bootstrap.projectService.persist(new Project(id, nameProject, description, dateCreate, bootstrap.user.getUserId()));
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
