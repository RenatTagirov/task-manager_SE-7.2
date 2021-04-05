package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return "project-create";
    }

    @Override
    public String getDescripion() {
        return "create a new project";
    }

    @Override
    public void execute() throws IOException {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        bootstrap.projectService.persist(new Project(id, nameProject, description, dateCreate));
        System.out.println("[OK]");
        System.out.println();
    }
}
