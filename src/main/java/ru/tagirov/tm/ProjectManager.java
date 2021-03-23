package ru.tagirov.tm;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {

    private final List<Project> project= new ArrayList<>();;

    public void projectClear(){
        if (project.size() > 0) {
            project.subList(0, project.size()).clear();
        }
    }

    public void projectCreate(String name){
        project.add(new Project(name));
    }

    public void projectList(){
        if(!(project.isEmpty())) {
            int count = 1;
            for (Project p : project) {
                System.out.println(count + ". " + p.getName());
                count++;
            }
        }else {
            System.out.println("[EMPTY]");
        }
    }

    public void projectRemove(String name){
        for(int i = 0; i < project.size(); i++){
            if(project.get(i).getName().equals(name)) {
                project.remove(i);
            }
        }
    }

    public void taskClear(String name){
        for (Project value : project) {
            if (value.getName().equals(name)) {
                value.clearTask();
            }
        }
    }

    public void taskCreate(String projectName, String taskName){
        for (Project value : project) {
            if (value.getName().equals(projectName)) {
                value.addTask(taskName);
            }
        }
    }

    public void taskList(String name){
        for (Project value : project) {
            if (value.getName().equals(name)) {
                value.printTask();
            }
        }
    }

    public void taskRemove(String projectName, String taskName){
        for (Project value : project) {
            if (value.getName().equals(projectName)) {
                value.removeTask(taskName);
            }
        }
    }

    public void help(){

        System.out.println("help: Show all commands. \n" +
                "project-clear: Remove all projects. \n" +
                "project-create: Create new project. \n" +
                "project-list: Show all projects. \n" +
                "project-remove: Remove selected projects. \n" +
                "task-clear: Remove all tasks. \n" +
                "task-create: Create new task. \n" +
                "task-list: Show all tasks. \n" +
                "task-remove: Remove selected task. \n");
    }
}
