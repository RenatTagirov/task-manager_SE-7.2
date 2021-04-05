package ru.tagirov.tm.Command;

import ru.tagirov.tm.Bootstrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name, nameTask, nameProject, description, dateCreate, or;
    Date data;
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public AbstractCommand(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract String getName();

    public abstract String getDescripion();

    public abstract void execute() throws IOException;

}
