package ru.tagirov.tm.Command.adminCommand;

import ru.tagirov.tm.Bootstrap;
import ru.tagirov.tm.Command.AbstractCommand;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class AdminShowTaskToProjectToUserCommand extends AbstractCommand {

    public AdminShowTaskToProjectToUserCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getDisplayName() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show-task-to-project-to-user";
    }

    @Override
    public String getDescription() {
        return "show user";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null && bootstrap.admin == null)){
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                if(tmp.getValue().getUserName().equals(name)){
                    bootstrap.user = tmp.getValue();
                    for(Map.Entry<String, AbstractCommand> command: bootstrap.commands.entrySet()){
                        if (command.getKey().equals("task-list-to-project")){
                            command.getValue().execute();
                        }
                    }
                    bootstrap.user = null;
                }else{
                    System.out.println("[YOU ENTERED THE WRONG VALUE!]");
                    System.out.println("TRY AGAIN, ENTER MORE OR CANCEL");
                    System.out.println();
                }
            }
        }else{
            System.out.println("[YOU ARE NOT LOGGED IN TO YOUR ACCOUNT!]");
            System.out.println();
        }
    }
}
