package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.ServiceLocator;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class HelpCommand extends AbstractCommand {


    public HelpCommand() {
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
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public void execute() {
        if (serviceLocator.getUser() == null){
            for(AbstractCommand tmp : serviceLocator.getCommands()){
                if (tmp.getRoleCommand().equals("all")){
                    System.out.println(tmp.getName() + " - " + tmp.getDescription());
                }
            }
            System.out.println();
        }else if(serviceLocator.getUser().getRole().getTitle().equals("user")){
            for(AbstractCommand tmp : serviceLocator.getCommands()){
                if (tmp.getRoleCommand().equals("all") || tmp.getRoleCommand().equals("user") ){
                    System.out.println(tmp.getName() + " - " + tmp.getDescription());
                }
            }
            System.out.println();
        }else if(serviceLocator.getUser().getRole().getTitle().equals("admin")){
            for(AbstractCommand tmp : serviceLocator.getCommands()){
                System.out.println(tmp.getName() + " - " + tmp.getDescription());
            }
        }else{
            System.out.println("SOMETHING WENT WRONG!?!?!?!?!");
        }
    }
}
