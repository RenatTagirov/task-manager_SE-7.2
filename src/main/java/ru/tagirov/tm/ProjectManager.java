package ru.tagirov.tm;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProjectManager {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final List<Project> projectList = new ArrayList<>();
    private final List<Task> taskList = new ArrayList<>();
    String name;
    String description;
    Date data;
    String dateCreate;
    String or;
    String nameTask;
    String nameProject;
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    String id;

    public void projectCreate() throws IOException {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        projectList.add(new Project(id, nameProject, description, dateCreate));
        System.out.println("[OK]");
        System.out.println();
    }

    public void projectUpdate() throws IOException {
        System.out.println("[PROJECT UPDATE]");
        System.out.println("ENTER PROJECT NAME:");
        name = reader.readLine();
        System.out.println("WHAT YOU WANT TO UPDATE?");
        System.out.println("NAME OR DESCRIPTION:");
        or = reader.readLine();
        if (or.equalsIgnoreCase("name")){
            for(Project p : projectList){
                if(p.getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    p.setName(reader.readLine());
                    data = new Date();
                    p.setDateUpdate(formatForDateNow.format(data));
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else if(or.equalsIgnoreCase("description")){
            for(Project p : projectList){
                if(p.getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    p.setDescription(reader.readLine());
                    data = new Date();
                    p.setDateUpdate(formatForDateNow.format(data));
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else {
            System.out.println("[YOU COMMAND IS INVALID]");
            System.out.println();
        }
    }

    public void projectList(){
        System.out.println("[PROJECT LIST]");
        if(!(projectList.isEmpty())){
            for(Project p : projectList){
                    if (p.getDateUpdate() == null){
                        System.out.println("Project name:");
                        System.out.println(p.getName());
                        System.out.println("Project description:");
                        System.out.println(p.getDescription());
                        System.out.println("Date create:");
                        System.out.println(p.getDateCreate());
                        System.out.println();
                    }else {
                        System.out.println("Project name:");
                        System.out.println(p.getName());
                        System.out.println("Project description:");
                        System.out.println(p.getDescription());
                        System.out.println("Date create:");
                        System.out.println(p.getDateCreate());
                        System.out.println("Date update:");
                        System.out.println(p.getDateUpdate());
                        System.out.println();
                    }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }
    }

    public void projectRemove() throws IOException {
        System.out.println("[PROJECT REMOVE]");
        System.out.println("ENTER PROJECT NAME:");
        name = reader.readLine();
        for(int i = 0; i < projectList.size(); i++){
            if(projectList.get(i).getName().equals(name))
            projectList.remove(i);
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void projectClear(){
        System.out.println("[PROJECT CLEAR]");
        Iterator<Project> iterator = projectList.iterator();
        while(iterator.hasNext()){
             Project o = iterator.next();
                iterator.remove();
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskCreate() throws IOException {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        name = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        taskList.add(new Task(id, name, description, dateCreate));
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskCreateToProject() throws IOException {
        System.out.println("[TASK CREATE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER NAME:");
        name = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        for(Project p : projectList){
            if (p.getName().equals(nameProject)){
                p.taskListToProject.add(new Task(id, name, description, dateCreate));
            }
        }
        System.out.println("[OK]");
        System.out.println();

    }

    public void taskUpdate() throws IOException {
        System.out.println("[TASK UPDATE]");
        System.out.println("ENTER TASK NAME:");
        name = reader.readLine();
        System.out.println("WHAT YOU WANT TO UPDATE?");
        System.out.println("NAME OR DESCRIPTION:");
        or = reader.readLine();
        if (or.equalsIgnoreCase("name")){
            for(Task p : taskList){
                if(p.getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    p.setName(reader.readLine());
                    data = new Date();
                    p.setDateUpdate(formatForDateNow.format(data));
                }
            }
        }else if(or.equalsIgnoreCase("description")){
            for(Task p : taskList){
                if(p.getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    p.setDescription(reader.readLine());
                    data = new Date();
                    p.setDateUpdate(formatForDateNow.format(data));
                }
            }
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskUpdateToProject() throws IOException {
        System.out.println("[TASK UPDATE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        for (Project p : projectList){
            if (p.getName().equals(nameProject)){
                System.out.println("ENTER TASK NAME:");
                nameTask = reader.readLine();
                for (int i = 0; i < p.taskListToProject.size(); i++){
                    if (p.taskListToProject.get(i).getName().equals(nameTask)){
                        System.out.println("WHAT YOU WANT TO UPDATE?");
                        System.out.println("NAME OR DESCRIPTION:");
                        or = reader.readLine();
                        if (or.equalsIgnoreCase("name")){
                            System.out.println("ENTER NEW NAME:");
                            p.taskListToProject.get(i).setName(reader.readLine());
                            data = new Date();
                            p.taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                        else if(or.equalsIgnoreCase("description")){
                            System.out.println("ENTER NEW DESCRIPTION:");
                            p.taskListToProject.get(i).setDescription(reader.readLine());
                            data = new Date();
                            p.taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    public void taskList(){
        System.out.println("[TASK LIST]");
        if(!(taskList.isEmpty())){
            for(Task p : taskList){
                if (p.getDateUpdate() == null){
                    System.out.println("Task name: " + p.getName());
                    System.out.println("Task description: " + p.getDescription());
                    System.out.println("Date create: " + p.getDateCreate());
                    System.out.println();
                }else {
                    System.out.println("Task name: " + p.getName());
                    System.out.println("Task description: " + p.getDescription());
                    System.out.println("Date create: " + p.getDateCreate());
                    System.out.println("Date update: " + p.getDateUpdate());
                    System.out.println();
                }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }
    }

    public void taskListToProject() throws IOException {
        System.out.println("[TASK LIST TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        int count = 1;
        if(!(projectList.isEmpty())){
            for(Project p : projectList){
                if (!(p.taskListToProject.isEmpty())) {
                    if (p.getName().equals(nameProject)) {
                        for (int i = 0; i < p.taskListToProject.size(); i++) {
                            if (p.taskListToProject.get(i).getDateUpdate() == null) {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(p.taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(p.taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(p.taskListToProject.get(i).getDateCreate());
                                System.out.println();
                                count++;
                            } else {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(p.taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(p.taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(p.taskListToProject.get(i).getDateCreate());
                                System.out.println("Date update:");
                                System.out.println(p.taskListToProject.get(i).getDateUpdate());
                                System.out.println();
                                count++;
                            }
                        }
                    }
                } else {
                    System.out.println("[EMPTY]");
                    System.out.println();
                }
            }
        }else{
            System.out.println("[EMPTY]");
            System.out.println();
        }

    }

    public void taskRemove() throws IOException {
        System.out.println("[TASK REMOVE]");
        System.out.println("ENTER TASK NAME:");
        name = reader.readLine();
        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).getName().equals(name))
                taskList.remove(i);
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskRemoveToProject() throws IOException {
        System.out.println("[TASK REMOVE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER TASK NAME:");
        nameTask = reader.readLine();
        for (Project p : projectList){
            if (p.getName().equals(nameProject)){
                for(int i = 0; i < p.taskListToProject.size(); i++){
                    if (p.taskListToProject.get(i).getName().equals(nameTask)){
                        p.taskListToProject.remove(i);
                    }
                }
            }

        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskClear(){
        System.out.println("[TASK CLEAR]");
        Iterator<Task> iterator = taskList.iterator();
        while(iterator.hasNext()){
            Task o = iterator.next();
            if(o instanceof Task){
                iterator.remove();
            }
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskClearToProject() throws IOException {
        System.out.println("[TASK CLEAR TO PROJECT]");
        System.out.println("TASK PROJECT NAME:");
        nameProject = reader.readLine();
        for(int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getName().equals(nameProject)){
                (projectList.get(i)).taskListToProject.clear();
            }
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskAddToProject() throws IOException {
        System.out.println("[TASK ADD TO PROJECT]");
        System.out.println("ENTER TASK NAME:");
        nameTask = reader.readLine();
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        String id1 = null;
        String name1 = null;
        String description1 = null;
        String dateCreate1 = null;
        String id2 = null;
        for(Task p : taskList){
            if (p.getName().equals(nameTask)) {
                id1 = p.getId();
                name1 = p.getName();
                description1 = p.getDescription();
                dateCreate1 = p.getDateCreate();
            }
        }
        for(Project p : projectList){
            if (p.getName().equals(nameProject)) {
                p.taskListToProject.add(new Task(id1, name1, description1, dateCreate1));
                id2 = p.getId();
            }
        }
        for (Project p : projectList){
            if (p.getName().equals(nameProject)) {
                for (int i = 0; i < p.taskListToProject.size(); i++) {
                    if (p.taskListToProject.get(i).getName().equals(nameTask)) {
                        p.taskListToProject.get(i).setIdProject(id2);
                    }
                }
            }
        }

        for(int i = 0; i < taskList.size(); i++){
                if (taskList.get(i).getName().equals(nameTask)) {
                    taskList.remove(i);
                }
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void listAll(){
        System.out.println("[LIST ALL]");
        int count = 1;
        if(!(projectList.isEmpty())) {
            System.out.println("PROJECTS:");
            for (Project p : projectList) {
                System.out.println(count + ". " + "PROJECT NAME:");
                System.out.println(p.getName());
                count++;
            }
            count = 1;
            System.out.println("TASKS:");
            for (Task p : taskList) {
                System.out.println(count + ". " + "TASK NAME:");
                System.out.println(((Task) p).getName());
                count++;
            }
        }else {
            System.out.println("[EMPTY]");
            System.out.println();
        }
        System.out.println();
    }

    public void clearAll(){
        projectList.clear();
        System.out.println("[OK]");
        System.out.println();
    }

    public void help(){
        System.out.println("help: " + Command.HELP.getDescription());
        System.out.println("PROJECT_CREATE: " + Command.PROJECT_CREATE.getDescription());
        System.out.println("PROJECT_UPDATE: " + Command.PROJECT_UPDATE.getDescription());
        System.out.println("PROJECT_LIST: " + Command.PROJECT_LIST.getDescription());
        System.out.println("PROJECT_REMOVE: " + Command.PROJECT_REMOVE.getDescription());
        System.out.println("PROJECT_CLEAR: " + Command.PROJECT_CLEAR.getDescription());
        System.out.println("TASK_CREATE: " + Command.TASK_CREATE.getDescription());
        System.out.println("TASK_CREATE_TO_PROJECT: " + Command.TASK_CREATE_TO_PROJECT.getDescription());
        System.out.println("TASK_UPDATE: " + Command.TASK_UPDATE.getDescription());
        System.out.println("TASK_UPDATE_TO_PROJECT: " + Command.TASK_UPDATE_TO_PROJECT.getDescription());
        System.out.println("TASK_LIST: " + Command.TASK_LIST.getDescription());
        System.out.println("TASK_LIST_TO_PROJECT: " + Command.TASK_LIST_TO_PROJECT.getDescription());
        System.out.println("TASK_REMOVE: " + Command.TASK_REMOVE.getDescription());
        System.out.println("TASK_REMOVE_TO_PROJECT: " + Command.TASK_REMOVE_TO_PROJECT.getDescription());
        System.out.println("TASK_CLEAR: " + Command.TASK_CLEAR.getDescription());
        System.out.println("TASK_CLEAR_TO_PROJECT: " + Command.TASK_CLEAR_TO_PROJECT.getDescription());
        System.out.println("TASK_ADD_TO_PROJECT: " + Command.TASK_ADD_TO_PROJECT.getDescription());
        System.out.println("LIST_ALL: " + Command.LIST_ALL.getDescription());
        System.out.println("CLEAR_ALL: " + Command.CLEAR_ALL.getDescription());
        System.out.println("HELP: " + Command.HELP.getDescription());
        System.out.println();
    }
}
