package ru.tagirov.tm.command.userCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class UserClearAllCommand extends AbstractCommand {


    public UserClearAllCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "user";
    }

    @Override
    public String getName() {
        return "clear all";
    }


    @Override
    public String getDescription() {
        return "delete all projects and tasks";
    }

    @Override
    public void execute() throws IOException {
        if (bootstrap.user == null) {
            if (bootstrap.user.getRole().getTitle().equals("user")) {
                bootstrap.projectService.removeAll();
                bootstrap.taskService.removeAll();
                System.out.println("[OK]");
                System.out.println();
            } else if (bootstrap.user.getRole().getTitle().equals("admin")) {
                System.out.println("ENTER PROFILE NAME:");
                name = reader.readLine();
                for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                    if (tmp.getValue().getUserName().equals(name)){
                        for (Map.Entry<String, Project> tmp1 : bootstrap.projectService.findAll().entrySet()) {
                            if (tmp1.getValue().getName().equals(name) && tmp1.getValue().getUserId().equals(bootstrap.user.getUserId())) {
                                bootstrap.projectService.remove(tmp1.getValue());
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
