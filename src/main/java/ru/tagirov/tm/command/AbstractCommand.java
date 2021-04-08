package ru.tagirov.tm.command;

import ru.tagirov.tm.Bootstrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    protected String enterRole;
    protected Date data;
    protected MessageDigest md5 = MessageDigest.getInstance("MD5");
    protected StringBuilder builder = new StringBuilder();
    protected StringBuilder newBuilder = new StringBuilder();
    protected byte[] bytes;
    protected byte[] newBytes;
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public AbstractCommand(Bootstrap bootstrap) throws NoSuchAlgorithmException {
        this.bootstrap = bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public String getRoleCommand() {
        return null;
    }

    public abstract String getName();
    public abstract String getDescription();
    public void execute() throws IOException{}
}
