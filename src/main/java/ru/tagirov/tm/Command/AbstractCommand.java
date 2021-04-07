package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractCommand {
    public Bootstrap bootstrap;
    protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected String id;
    protected String userId;
    protected String userName;
    protected String login;
    protected String password;
    protected String newPassword;
    protected String displayName;
    protected String name;
    protected String nameTask;
    protected String nameProject;
    protected String description;
    protected String dateCreate;
    protected String or;
    protected Date data;
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public AbstractCommand(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract String getDisplayName();
    public abstract String getName();
    public abstract String getDescription();
    public void execute() throws IOException{}
}
