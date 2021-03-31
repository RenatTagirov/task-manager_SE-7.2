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
    private final List<Object> projectList = new ArrayList<>();
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
            for(Object p : projectList){
                if(((Project) p).getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    ((Project) p).setName(reader.readLine());
                    data = new Date();
                    ((Project) p).setDateUpdate(formatForDateNow.format(data));
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else if(or.equalsIgnoreCase("description")){
            for(Object p : projectList){
                if(((Project) p).getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    ((Project) p).setDescription(reader.readLine());
                    data = new Date();
                    ((Project) p).setDateUpdate(formatForDateNow.format(data));
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
            for(Object p : projectList){
                if(p instanceof Project){
                    if (((Project) p).getDateUpdate() == null){
                        System.out.println("Project name:");
                        System.out.println(((Project) p).getName());
                        System.out.println("Project description:");
                        System.out.println(((Project) p).getDescription());
                        System.out.println("Date create:");
                        System.out.println(((Project) p).getDateCreate());
                        System.out.println();
                    }else {
                        System.out.println("Project name:");
                        System.out.println(((Project) p).getName());
                        System.out.println("Project description:");
                        System.out.println(((Project) p).getDescription());
                        System.out.println("Date create:");
                        System.out.println(((Project) p).getDateCreate());
                        System.out.println("Date update:");
                        System.out.println(((Project) p).getDateUpdate());
                        System.out.println();
                    }
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
            if(((Project) projectList.get(i)).getName().equals(name))
            projectList.remove(i);
        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void projectClear(){
        System.out.println("[PROJECT CLEAR]");
        Iterator<Object> iterator = projectList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            if(o instanceof Project){
                iterator.remove();
            }
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
        projectList.add(new Task(id, name, description, dateCreate));
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
        for(Object p : projectList){
            if (((Project) p).getName().equals(nameProject)){
                ((Project) p).taskList.add(new Task(id, name, description, dateCreate));
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
            for(Object p : projectList){
                if(((Task) p).getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    ((Task) p).setName(reader.readLine());
                    data = new Date();
                    ((Task) p).setDateUpdate(formatForDateNow.format(data));
                }
            }
        }else if(or.equalsIgnoreCase("description")){
            for(Object p : projectList){
                if(((Task) p).getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    ((Task) p).setDescription(reader.readLine());
                    data = new Date();
                    ((Task) p).setDateUpdate(formatForDateNow.format(data));
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
        for (Object p : projectList){
            if (((Project)p).getName().equals(nameProject)){
                System.out.println("ENTER TASK NAME:");
                nameTask = reader.readLine();
                for (int i = 0; i < ((Project)p).taskList.size(); i++){
                    if (((Project)p).taskList.get(i).getName().equals(nameTask)){
                        System.out.println("WHAT YOU WANT TO UPDATE?");
                        System.out.println("NAME OR DESCRIPTION:");
                        or = reader.readLine();
                        if (or.equalsIgnoreCase("name")){
                            System.out.println("ENTER NEW NAME:");
                            ((Project)p).taskList.get(i).setName(reader.readLine());
                            data = new Date();
                            ((Project)p).taskList.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                        else if(or.equalsIgnoreCase("description")){
                            System.out.println("ENTER NEW DESCRIPTION:");
                            ((Project)p).taskList.get(i).setDescription(reader.readLine());
                            data = new Date();
                            ((Project)p).taskList.get(i).setDateUpdate(formatForDateNow.format(data));
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
        if(!(projectList.isEmpty())){
            for(Object p : projectList){
                if(p instanceof Task){
                    if (((Task) p).getDateUpdate() == null){
                        System.out.println("Task name: " + ((Task) p).getName());
                        System.out.println("Task description: " + ((Task) p).getDescription());
                        System.out.println("Date create: " + ((Task) p).getDateCreate());
                        System.out.println();
                    }else {
                        System.out.println("Task name: " + ((Task) p).getName());
                        System.out.println("Task description: " + ((Task) p).getDescription());
                        System.out.println("Date create: " + ((Task) p).getDateCreate());
                        System.out.println("Date update: " + ((Task) p).getDateUpdate());
                        System.out.println();
                    }
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
            for(Object p : projectList){
                if (p instanceof Project) {
                    if (!(((Project) p).taskList.isEmpty())) {
                        if (((Project) p).getName().equals(nameProject)) {
                            for (int i = 0; i < ((Project) p).taskList.size(); i++) {
                                if (((Project) p).taskList.get(i).getDateUpdate() == null) {
                                    System.out.println(count + ". " + "Task name:");
                                    System.out.println(((Project) p).taskList.get(i).getName());
                                    System.out.println("Task description:");
                                    System.out.println(((Project) p).taskList.get(i).getDescription());
                                    System.out.println("Date create:");
                                    System.out.println(((Project) p).taskList.get(i).getDateCreate());
                                    System.out.println();
                                    count++;
                                } else {
                                    System.out.println(count + ". " + "Task name:");
                                    System.out.println(((Project) p).taskList.get(i).getName());
                                    System.out.println("Task description:");
                                    System.out.println(((Project) p).taskList.get(i).getDescription());
                                    System.out.println("Date create:");
                                    System.out.println(((Project) p).taskList.get(i).getDateCreate());
                                    System.out.println("Date update:");
                                    System.out.println(((Project) p).taskList.get(i).getDateUpdate());
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
        for(int i = 0; i < projectList.size(); i++){
            if(((Task) projectList.get(i)).getName().equals(name))
                projectList.remove(i);
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
        for (Object p : projectList){
            if (((Project)p).getName().equals(nameProject)){
                for(int i = 0; i < ((Project)p).taskList.size(); i++){
                    if (((Project)p).taskList.get(i).getName().equals(nameTask)){
                        ((Project)p).taskList.remove(i);
                    }
                }
            }

        }

    }

    public void taskClear(){
        System.out.println("[TASK CLEAR]");
        Iterator<Object> iterator = projectList.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
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
            if (((Project) projectList.get(i)).getName().equals(nameProject)){
                ((Project) projectList.get(i)).taskList.clear();
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
        for(Object p : projectList){
            if (p instanceof Task) {
                if (((Task) p).getName().equals(nameTask)) {
                    id1 = ((Task) p).getId();
                    name1 = ((Task) p).getName();
                    description1 = ((Task) p).getDescription();
                    dateCreate1 = ((Task) p).getDateCreate();
                }
            }
        }
        for(Object o : projectList){
            if (o instanceof Project) {
                if (((Project) o).getName().equals(nameProject)) {
                    ((Project) o).taskList.add(new Task(id1, name1, description1, dateCreate1));
                    id2 = ((Project) o).getId();
                }
            }
        }
        for (Object p : projectList){
            if (p instanceof Project) {
                if (((Project) p).getName().equals(nameProject)) {
                    for (int i = 0; i < ((Project) p).taskList.size(); i++) {
                        if (((Project) p).taskList.get(i).getName().equals(nameTask)) {
                            ((Project) p).taskList.get(i).setIdProject(id2);
                        }
                    }
                }
            }

        }

        for(int i = 0; i < projectList.size(); i++){
            if (projectList.get(i) instanceof Task) {
                if (((Task) projectList.get(i)).getName().equals(nameTask)) {
                    projectList.remove(i);
                }
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
            for (Object p : projectList) {
                if (p instanceof Project) {
                    System.out.println(count + ". " + "PROJECT NAME:");
                    System.out.println(((Project) p).getName());
                    count++;
                }
            }
            count = 1;
            System.out.println("TASKS:");
            for (Object p : projectList) {
                if (p instanceof Task) {
                    System.out.println(count + ". " + "TASK NAME:");
                    System.out.println(((Task) p).getName());
                    count++;
                }
            }
        }else {
            System.out.println("[EMPTY]");
        }
    }

    public void clearAll(){
        projectList.clear();
        System.out.println("[OK]");
        System.out.println();
    }

    public void help(){
        System.out.println("help: Show all commands. \n" +
                "PROJECT_CREATE: create a new project. \n" +
                "PROJECT_UPDATE: update a project. \n" +
                "PROJECT_LIST: show all project. \n" +
                "PROJECT_REMOVE: delete a project. \n" +
                "PROJECT_CLEAR: delete all project. \n" +
                "TASK_CREATE: create a new task. \n" +
                "TASK_CREATE_TO_PROJECT: create a new task in the project. \n" +
                "TASK_UPDATE: update a task. \n" +
                "TASK_UPDATE_TO_PROJECT: update a task in the project. \n" +
                "TASK_LIST: show all task. \n" +
                "TASK_LIST_TO_PROJECT: show all task in the project. \n" +
                "TASK_REMOVE: delete a task. \n" +
                "TASK_REMOVE_TO_PROJECT: delete a task in the project. \n" +
                "TASK_CLEAR: delete all task. \n" +
                "TASK_CLEAR_TO_PROJECT: delete all task in the project. \n" +
                "TASK_ADD_TO_PROJECT: add a task to the project. \n" +
                "LIST_ALL: show all. \n" +
                "CLEAR_ALL: delete all. \n" +
                "HELP: help. ");
    }
}
