package ru.tagirov.tm.entity;

import java.util.ArrayList;
import java.util.List;

public class Project{

    private String id;
    private String name;
    private String description;
    private String dateCreate;
    private String dateUpdate;
    public List<Task> taskList = new ArrayList<>();

    public Project(){
    }

    public Project(String id, String name, String description, String dateCreate){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
