package ru.tagirov.tm.entity;

import ru.tagirov.tm.enumeration.Role;

import java.util.Objects;

public class User extends AbstractEntity{

    private String name;
    private String login;
    private String password;
    private Role role;
    private String dateCreate;
    private String dateUpdate;

    public User(String id, String name, String login, String password, Role role, String dateCreate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.dateCreate = dateCreate;
    }


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(dateCreate, user.dateCreate) &&
                Objects.equals(dateUpdate, user.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, role, dateCreate, dateUpdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + id + '\'' +
                ", userName='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + role + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                '}';
    }

}
