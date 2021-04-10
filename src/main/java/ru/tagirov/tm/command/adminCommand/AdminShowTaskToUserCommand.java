package ru.tagirov.tm.command.adminCommand;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;

import java.io.IOException;
import java.util.Map;

public class AdminShowTaskToUserCommand extends AbstractCommand {

    public AdminShowTaskToUserCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "admin";
    }

    @Override
    public String getName() {
        return "show tasks user";
    }

    @Override
    public String getDescription() {
        return "view all user tasks";
    }

    @Override
    public void execute() throws IOException {
        if(!(bootstrap.user == null)){
            System.out.println("[SHOW PROJECTS TO USER]");
            System.out.println("[ENTER NAME PROFILE]");
            name = reader.readLine();
            for(Map.Entry<String, User> tmp : bootstrap.userService.findAll().entrySet()){
                if(tmp.getValue().getUserName().equals(name)){
                    for (Map.Entry<String, Task> tmp1 : bootstrap.taskService.findAll().entrySet()) {
                        if (tmp1.getValue().getUserId().equals(tmp.getValue().getUserId())) {
                            if (tmp1.getValue().getDateUpdate() == null) {
                                System.out.println("Task name: " + tmp1.getValue().getName());
                                System.out.println("Task description: " + tmp1.getValue().getDescription());
                                System.out.println("Date create: " + tmp1.getValue().getDateCreate());
                                System.out.println();
                            }else {
                                System.out.println("Task name: " + tmp1.getValue().getName());
                                System.out.println("Task description: " + tmp1.getValue().getDescription());
                                System.out.println("Date create: " + tmp1.getValue().getDateCreate());
                                System.out.println("Date update: " + tmp1.getValue().getDateUpdate());
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
