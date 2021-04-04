package ru.tagirov.tm;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.repository.ProjectRepository;
import ru.tagirov.tm.repository.TaskRepository;
import ru.tagirov.tm.service.ProjectService;
import ru.tagirov.tm.service.TaskService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bootstrap {

    ProjectRepository projectRepository = new ProjectRepository();
    ProjectService projectService = new ProjectService(projectRepository);
    TaskRepository taskRepository = new TaskRepository();
    TaskService taskService = new TaskService(taskRepository);

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final List<Task> taskList = new ArrayList<>();
    String name;
    String description;
    Date data;
    String dateCreate;
    String or;
    String nameTask;
    String nameProject;
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public void init() throws IOException {
        String line;
        Command command = Command.HELP;
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while(!(line= reader.readLine()).equalsIgnoreCase("EXIT")){
            for (Command value : Command.values()) {
                if (value.getTitle().equals(line)) {
                    command = value;
                    break;
                }
            }
            switch(command){
                case PROJECT_CREATE:
                    projectCreate();
                    break;
                case PROJECT_UPDATE:
                    projectUpdate();
                    break;
                case PROJECT_LIST:
                    projectList();
                    break;
                case PROJECT_REMOVE:
                    projectRemove();
                    break;
                case PROJECT_CLEAR:
                    projectClear();
                    break;
                case TASK_CREATE:
                    taskCreate();
                    break;
                case TASK_CREATE_TO_PROJECT:
                    taskCreateToProject();
                    break;
                case TASK_UPDATE:
                    taskUpdate();
                    break;
                case TASK_UPDATE_TO_PROJECT:
                    taskUpdateToProject();
                    break;
                case TASK_LIST:
                    taskList();
                    break;
                case TASK_LIST_TO_PROJECT:
                    taskListToProject();
                    break;
                case TASK_REMOVE:
                    taskRemove();
                    break;
                case TASK_REMOVE_TO_PROJECT:
                    taskRemoveToProject();
                    break;
                case TASK_CLEAR:
                    taskClear();
                    break;
                case TASK_CLEAR_TO_PROJECT:
                    taskClearToProject();
                    break;
                case TASK_ADD_TO_PROJECT:
                    taskAddToProject();
                    break;
                case LIST_ALL:
                    listAll();
                    break;
                case CLEAR_ALL:
                    clearAll();
                    break;
                case HELP:
                    help();
                    break;
            }
        }
    }

    public void projectCreate() throws IOException {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER DESCRIPTION:");
        description = reader.readLine();
        data = new Date();
        dateCreate = formatForDateNow.format(data);
        String id = UUID.randomUUID().toString();
        projectService.persist(new Project(id, nameProject, description, dateCreate));
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
            for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    tmp.getValue().setName(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                }
            }
            System.out.println("[OK]");
            System.out.println();
        }else if(or.equalsIgnoreCase("description")){
            for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    tmp.getValue().setDescription(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
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
        if(!(projectService.findAll().isEmpty())){
            for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
                    if (tmp.getValue().getDateUpdate() == null){
                        System.out.println("Project name:");
                        System.out.println(tmp.getValue().getName());
                        System.out.println("Project description:");
                        System.out.println(tmp.getValue().getDescription());
                        System.out.println("Date create:");
                        System.out.println(tmp.getValue().getDateCreate());
                        System.out.println();
                    }else {
                        System.out.println("Project name:");
                        System.out.println(tmp.getValue().getName());
                        System.out.println("Project description:");
                        System.out.println(tmp.getValue().getDescription());
                        System.out.println("Date create:");
                        System.out.println(tmp.getValue().getDateCreate());
                        System.out.println("Date update:");
                        System.out.println(tmp.getValue().getDateUpdate());
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
        Project project = null;
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(name)){
                project = tmp.getValue();
            }
        }
        projectService.remove(project);
        System.out.println("[OK]");
        System.out.println();
    }

    public void projectClear(){
        System.out.println("[PROJECT CLEAR]");
        projectService.removeAll();
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
        taskService.persist(new Task(id, name, description, dateCreate));
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
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)){
                tmp.getValue().taskListToProject.add(new Task(id, name, description, dateCreate));
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
            for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW NAME:");
                    tmp.getValue().setName(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
                }
            }
        }else if(or.equalsIgnoreCase("description")){
            for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
                if(tmp.getValue().getName().equals(name)){
                    System.out.println("ENTER NEW DESCRIPTION:");
                    tmp.getValue().setDescription(reader.readLine());
                    data = new Date();
                    tmp.getValue().setDateUpdate(formatForDateNow.format(data));
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
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)){
                System.out.println("ENTER TASK NAME:");
                nameTask = reader.readLine();
                for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++){
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)){
                        System.out.println("WHAT YOU WANT TO UPDATE?");
                        System.out.println("NAME OR DESCRIPTION:");
                        or = reader.readLine();
                        if (or.equalsIgnoreCase("name")){
                            System.out.println("ENTER NEW NAME:");
                            tmp.getValue().taskListToProject.get(i).setName(reader.readLine());
                            data = new Date();
                            tmp.getValue().taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
                            System.out.println("[OK]");
                            System.out.println();
                        }
                        else if(or.equalsIgnoreCase("description")){
                            System.out.println("ENTER NEW DESCRIPTION:");
                            tmp.getValue().taskListToProject.get(i).setDescription(reader.readLine());
                            data = new Date();
                            tmp.getValue().taskListToProject.get(i).setDateUpdate(formatForDateNow.format(data));
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
        if(!(taskService.findAll().isEmpty())){
            for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
                if (tmp.getValue().getDateUpdate() == null){
                    System.out.println("Task name: " + tmp.getValue().getName());
                    System.out.println("Task description: " + tmp.getValue().getDescription());
                    System.out.println("Date create: " + tmp.getValue().getDateCreate());
                    System.out.println();
                }else {
                    System.out.println("Task name: " + tmp.getValue().getName());
                    System.out.println("Task description: " + tmp.getValue().getDescription());
                    System.out.println("Date create: " + tmp.getValue().getDateCreate());
                    System.out.println("Date update: " + tmp.getValue().getDateUpdate());
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
        if(!(projectService.findAll().isEmpty())){
            for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
                if (!(tmp.getValue().taskListToProject.isEmpty())) {
                    if (tmp.getValue().getName().equals(nameProject)) {
                        for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                            if (tmp.getValue().taskListToProject.get(i).getDateUpdate() == null) {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateCreate());
                                System.out.println();
                                count++;
                            } else {
                                System.out.println(count + ". " + "Task name:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getName());
                                System.out.println("Task description:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDescription());
                                System.out.println("Date create:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateCreate());
                                System.out.println("Date update:");
                                System.out.println(tmp.getValue().taskListToProject.get(i).getDateUpdate());
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
        Task task = null;
        name = reader.readLine();
        for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
            if(tmp.getValue().getName().equals(name))
                task = tmp.getValue();
        }
        taskService.remove(task);
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskRemoveToProject() throws IOException {
        System.out.println("[TASK REMOVE TO PROJECT]");
        System.out.println("ENTER PROJECT NAME:");
        nameProject = reader.readLine();
        System.out.println("ENTER TASK NAME:");
        nameTask = reader.readLine();
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)){
                for(int i = 0; i < tmp.getValue().taskListToProject.size(); i++){
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)){
                        tmp.getValue().taskListToProject.remove(i);
                    }
                }
            }

        }
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskClear(){
        System.out.println("[TASK CLEAR]");
        taskService.removeAll();
        System.out.println("[OK]");
        System.out.println();
    }

    public void taskClearToProject() throws IOException {
        System.out.println("[TASK CLEAR TO PROJECT]");
        System.out.println("TASK PROJECT NAME:");
        Project project = null;
        nameProject = reader.readLine();
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()) {
            if (tmp.getValue().getName().equals(nameProject)){
                project = tmp.getValue();
            }
        }
        projectService.findOne(project).taskListToProject.clear();
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
        Task task = null;
        for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameTask)) {
                id1 = tmp.getValue().getId();
                name1 = tmp.getValue().getName();
                description1 = tmp.getValue().getDescription();
                dateCreate1 = tmp.getValue().getDateCreate();
            }
        }
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)) {
                tmp.getValue().taskListToProject.add(new Task(id1, name1, description1, dateCreate1));
                id2 = tmp.getValue().getId();
            }
        }
        for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()){
            if (tmp.getValue().getName().equals(nameProject)) {
                for (int i = 0; i < tmp.getValue().taskListToProject.size(); i++) {
                    if (tmp.getValue().taskListToProject.get(i).getName().equals(nameTask)) {
                        tmp.getValue().taskListToProject.get(i).setIdProject(id2);
                    }
                }
            }
        }

        for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()){
                if (tmp.getValue().getName().equals(nameTask)) {
                    task = tmp.getValue();
                }
        }
        taskService.remove(task);
        System.out.println("[OK]");
        System.out.println();
    }

    public void listAll(){
        System.out.println("[LIST ALL]");
        int count = 1;
        if(!(projectService.findAll().isEmpty() && taskService.findAll().isEmpty())) {
            System.out.println("PROJECTS:");
            for(Map.Entry<String, Project> tmp : projectService.findAll().entrySet()) {
                System.out.println(count + ". " + "PROJECT NAME:");
                System.out.println(tmp.getValue().getName());
                count++;
            }
            count = 1;
            System.out.println("TASKS:");
            for(Map.Entry<String, Task> tmp : taskService.findAll().entrySet()) {
                System.out.println(count + ". " + "TASK NAME:");
                System.out.println(tmp.getValue().getName());
                count++;
            }
        }else {
            System.out.println("[EMPTY]");
            System.out.println();
        }
        System.out.println();
    }

    public void clearAll(){
        projectService.removeAll();
        taskService.removeAll();
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
