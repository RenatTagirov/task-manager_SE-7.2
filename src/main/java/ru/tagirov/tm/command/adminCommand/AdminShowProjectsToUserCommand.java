package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class AdminShowProjectsToUserCommand extends AbstractCommand {

    public AdminShowProjectsToUserCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show projects user";
    }

    @Override
    public String getDescription() {
        return "view all user projects";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                if(tmp.getValue().getUserName().equals(name)){
                    for (Map.Entry<String, Project> tmp1 : bootstrap.projectService.findAll().entrySet()) {
                        if (tmp1.getValue().getUserId().equals(tmp.getValue().getUserId())) {
                            if (tmp.getValue().getDateUpdate() == null) {
                                System.out.println("Project name:");
                                System.out.println(tmp1.getValue().getName());
                                System.out.println("Project description:");
                                System.out.println(tmp1.getValue().getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp1.getValue().getDateCreate());
                                System.out.println();
                            } else {
                                System.out.println("Project name:");
                                System.out.println(tmp1.getValue().getName());
                                System.out.println("Project description:");
                                System.out.println(tmp1.getValue().getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp1.getValue().getDateCreate());
                                System.out.println("Date update:");
                                System.out.println(tmp1.getValue().getDateUpdate());
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
