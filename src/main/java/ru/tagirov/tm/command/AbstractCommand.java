package ru.tagirov.tm.command;

import ru.tagirov.tm.init.Bootstrap;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public abstract class AbstractCommand {
    public ServiceLocator serviceLocator;
    protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected String id;
    protected String userName;
    protected String login;
    protected String password;
    protected String newPassword;
    protected String name;
    protected String nameTask;
    protected String nameProject;
    protected String description;
    protected String dateCreate;
    protected String or;
    protected String enterRole;

    public AbstractCommand(){
    }

    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public String getRoleCommand() {
        return null;
    }

    public abstract String getName();
    public abstract String getDescription();
    public void execute() throws IOException{}
}
