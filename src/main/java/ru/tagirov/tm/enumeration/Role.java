package ru.tagirov.tm.enumeration;

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

    public static Role getRole(String role){
        Role newRole = null;
        for (Role value : Role.values()) {
            if (value.getTitle().equalsIgnoreCase(role)) {
                 newRole = value;
                break;
            }
        }
        return newRole;
    }
}
