package ru.tagirov.tm.command.taskCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import java.io.IOException;

import java.util.Map;

public class TaskUpdateToProjectCommand extends AbstractCommand {

    public TaskUpdateToProjectCommand(Bootstrap bootstrap){
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "task update to project";
    }

    @Override
    public String getDescription() {
        return "edit the selected task in the project";
    }

    @Override
    public void execute() throws IOException {
        if (!(bootstrap.user == null)) {
            System.out.println("[TASK UPDATE TO PROJECT]");
            System.out.println("ENTER PROJECT NAME:");
            nameProject = reader.readLine();
            for (Map.Entry<String, Project> tmp : bootstrap.projectService.findAll().entrySet()) {
                if (tmp.getValue().getName().equals(nameProject) && tmp.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                    System.out.println("ENTER TASK NAME:");
                    nameTask = reader.readLine();
                    for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                        if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)) {
                            System.out.println("WHAT YOU WANT TO UPDATE?");
                            System.out.println("NAME OR DESCRIPTION:");
                            or = reader.readLine();
                            if (or.equalsIgnoreCase("name")) {
                                System.out.println("ENTER NEW NAME:");
                                tmp.getValue().taskListToProject.get(i).setName(reader.readLine());
                                tmp.getValue().taskListToProject.get(i).setDateUpdate(bootstrap.getDate.getDate());
                                System.out.println("[OK]");
                                System.out.println();
                            } else if (or.equalsIgnoreCase("description")) {
                                System.out.println("ENTER NEW DESCRIPTION:");
                                tmp.getValue().taskListToProject.get(i).setDescription(reader.readLine());
                                tmp.getValue().taskListToProject.get(i).setDateUpdate(bootstrap.getDate.getDate());
                                System.out.println("[OK]");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
