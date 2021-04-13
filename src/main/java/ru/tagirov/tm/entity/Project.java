package ru.tagirov.tm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project extends AbstractEntity{

    private String name;
    private String description;
    private String dateCreate;
    private String dateUpdate;
    private String userId;
    public List<Task> taskListToProject = new ArrayList<>();

    public Project(){
    }

    public Project(String id, String name, String description, String dateCreate, String userId){
        this.id = id;
        this.name = name;
        this.description = description;
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

    public List<Task> getTaskListToProject() {
        return taskListToProject;
    }

    public void setTaskListToProject(List<Task> taskListToProject) {
        this.taskListToProject = taskListToProject;
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
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(dateCreate, project.dateCreate) &&
                Objects.equals(dateUpdate, project.dateUpdate) &&
                Objects.equals(taskListToProject, project.taskListToProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreate, dateUpdate, taskListToProject);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                ", taskList=" + taskListToProject +
                '}';
    }
}
