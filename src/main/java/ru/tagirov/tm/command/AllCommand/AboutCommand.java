package ru.tagirov.tm.command.AllCommand;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.IOException;

public class AboutCommand extends AbstractCommand {
    public AboutCommand() {
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getDescription() {
        return "about";
    }

    @Override
    public void execute() throws IOException {
        System.out.println("about");
    }
}
