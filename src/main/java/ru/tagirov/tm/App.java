package ru.tagirov.tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{
    public static void main( String[] args ) throws IOException {
        ProjectManager pm = new ProjectManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        String projectName;
        String taskName;

        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while(!(command= reader.readLine()).equalsIgnoreCase("EXIT")){
            switch(command){
                case("project-clear"): //Удалить все проекты
                    System.out.println("[PROJECT CLEAR]");
                    pm.projectClear();
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("project-create"): //Создать новый проект
                    System.out.println("[PROJECT CREATE]");
                    System.out.println("ENTER NAME:");
                    pm.projectCreate(projectName = reader.readLine());
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("project-list"): //Показать все проекты
                    System.out.println("[PROJECT LIST]");
                    pm.projectList();
                    System.out.println();
                    break;
                case("project-remove"): //Удалить выбранный проект
                    System.out.println("[PROJECT REMOVE]");
                    System.out.println("ENTER NAME PROJECT:");
                    pm.projectRemove(projectName = reader.readLine());
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("task-clear"): //Удалить все задачи
                    System.out.println("[PROJECT CLEAR]");
                    System.out.println("ENTER NAME PROJECT:");
                    pm.taskClear(projectName = reader.readLine());
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("task-create"): //Создать новую задачу
                    System.out.println("[TASK CREATE]");
                    System.out.println("ENTER NAME PROJECT:");
                    projectName = reader.readLine();
                    System.out.println("ENTER NAME:");
                    taskName= reader.readLine();
                    pm.taskCreate(projectName, taskName);
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("task-list"): //Показать все задачи
                    System.out.println("[TASK LIST]");
                    System.out.println("ENTER NAME PROJECT:");
                    pm.taskList(projectName = reader.readLine());
                    System.out.println();
                    break;
                case("task-remove"): //Удалить выбранную задачу
                    System.out.println("[TASK REMOVE]");
                    System.out.println("ENTER NAME PROJECT:");
                    projectName = reader.readLine();
                    System.out.println("ENTER NAME TASK:");
                    taskName= reader.readLine();
                    pm.taskRemove(projectName, taskName);
                    System.out.println("[OK]");
                    System.out.println();
                    break;
                case("help"): //Помощь
                    pm.help();
                    System.out.println();
                    break;
            }
        }
    }
}
