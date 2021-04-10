package ru.tagirov.tm.command.projectCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "project create";
    }

    @Override
    public String getDescription() {
        return "create a new project";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null)) {
            System.out.println("[PROJECT CREATE]");
            System.out.println("ENTER NAME:");
            nameProject = reader.readLine();
            System.out.println("ENTER DESCRIPTION:");
            description = reader.readLine();
            dateCreate = bootstrap.getDate.getDate();
            id = bootstrap.uuid.getUuid();
            bootstrap.projectService.persist(new Project(id, nameProject, description, dateCreate, bootstrap.user.getUserId()));
            System.out.println("[OK]");
            System.out.println();
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
