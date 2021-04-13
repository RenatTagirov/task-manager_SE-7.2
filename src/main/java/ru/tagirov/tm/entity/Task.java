package ru.tagirov.tm.entity;

import java.util.Objects;

public class Task extends AbstractEntity{

    private String name;
    private String description;
    private String dateCreate;
    private String dateUpdate;
    private String idProject;
    private String userId;

    public Task(){
    }

    public Task(String id, String name, String descript, String dateCreate, String userId) {
        this.id = id;
        this.name = name;
        this.description = descript;
        this.dateCreate = dateCreate;
        this.userId = userId;
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

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(dateCreate, task.dateCreate) &&
                Objects.equals(dateUpdate, task.dateUpdate) &&
                Objects.equals(idProject, task.idProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreate, dateUpdate, idProject);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                ", idProject='" + idProject + '\'' +
                '}';
    }
}
