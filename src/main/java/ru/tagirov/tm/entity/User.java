package ru.tagirov.tm.entity;

import java.util.Objects;

public class User {
    private String userId;
    private String userName;
    private String login;
    private String  password;
    private String displayName;
    private String dateCreate;
    private String dateUpdate;

    public User(String userId, String userName, String login, String password, String displayName, String dateCreate) {
        this.userId = userId;
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.displayName = displayName;
        this.dateCreate = dateCreate;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(displayName, user.displayName) &&
                Objects.equals(dateCreate, user.dateCreate) &&
                Objects.equals(dateUpdate, user.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, login, password, displayName, dateCreate, dateUpdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                '}';
    }
}
