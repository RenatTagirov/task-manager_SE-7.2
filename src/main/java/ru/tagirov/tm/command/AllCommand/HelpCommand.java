package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class HelpCommand extends AbstractCommand {


    public HelpCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "view all commands";
    }

    @Override
    public void execute() {
        if (bootstrap.user == null){
            for(Map.Entry<String, AbstractCommand> tmp : bootstrap.commands.entrySet()){
                if (tmp.getValue().getRoleCommand().equals("all")){
                    System.out.println(tmp.getValue().getName() + " - " + tmp.getValue().getDescription());
                }
            }
            System.out.println();
        }else if(bootstrap.user.getRole().getTitle().equals("user")){
            for(Map.Entry<String, AbstractCommand> tmp : bootstrap.commands.entrySet()){
                if (tmp.getValue().getRoleCommand().equals("all") || tmp.getValue().getRoleCommand().equals("user") ){
                    System.out.println(tmp.getValue().getName() + " - " + tmp.getValue().getDescription());
                }
            }
            System.out.println();
        }else if(bootstrap.user.getRole().getTitle().equals("admin")){
            for(Map.Entry<String, AbstractCommand> tmp : bootstrap.commands.entrySet()){
                System.out.println(tmp.getValue().getName() + " - " + tmp.getValue().getDescription());
            }
        }else{
            System.out.println("SOMETHING WENT WRONG!?!?!?!?!");
        }
    }
}
