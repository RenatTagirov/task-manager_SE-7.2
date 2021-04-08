package ru.tagirov.tm;

public enum  Role {
    ADMIN("admin"),
    USER("user");

    String title;

    Role(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
