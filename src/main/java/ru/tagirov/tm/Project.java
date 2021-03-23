package ru.tagirov.tm;

import java.util.ArrayList;
import java.util.List;

public class Project{

    private String name;
    public List<Task> taskList = new ArrayList<>();

    public Project(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void clearTask(){
        if (taskList.size() > 0) {
            taskList.subList(0, taskList.size()).clear();
        }
    }

    public void addTask(String name){
        taskList.add(new Task(name));
    }

    public void printTask(){
        if(!(taskList.isEmpty())){
            int count = 1;
            for (Task t : taskList) {
                System.out.println(count + ". " + t.getName());
                count++;
            }
        }else {
            System.out.println("[PROJECT IS EMPTY]");
        }
    }

    public void removeTask(String name){
        for(int i = 0; i < taskList.size(); i++){
            if (taskList.get(i).getName().equals(name)){
                taskList.remove(i);
            }
        }
    }
}
