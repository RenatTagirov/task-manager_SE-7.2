package ru.tagirov.tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main( String[] args ) throws IOException {
        ProjectManager pm = new ProjectManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
                    pm.projectCreate();
                    break;
                case PROJECT_UPDATE:
                    pm.projectUpdate();
                    break;
                case PROJECT_LIST:
                    pm.projectList();
                    break;
                case PROJECT_REMOVE:
                    pm.projectRemove();
                    break;
                case PROJECT_CLEAR:
                    pm.projectClear();
                    break;
                case TASK_CREATE:
                    pm.taskCreate();
                    break;
                case TASK_CREATE_TO_PROJECT:
                    pm.taskCreateToProject();
                    break;
                case TASK_UPDATE:
                    pm.taskUpdate();
                    break;
                case TASK_UPDATE_TO_PROJECT:
                    pm.taskUpdateToProject();
                    break;
                case TASK_LIST:
                    pm.taskList();
                    break;
                case TASK_LIST_TO_PROJECT:
                    pm.taskListToProject();
                    break;
                case TASK_REMOVE:
                    pm.taskRemove();
                    break;
                case TASK_REMOVE_TO_PROJECT:
                    pm.taskRemoveToProject();
                    break;
                case TASK_CLEAR:
                    pm.taskClear();
                    break;
                case TASK_CLEAR_TO_PROJECT:
                    pm.taskClearToProject();
                    break;
                case TASK_ADD_TO_PROJECT:
                    pm.taskAddToProject();
                    break;
                case LIST_ALL:
                    pm.listAll();
                    break;
                case CLEAR_ALL:
                    pm.clearAll();
                    break;
                case HELP:
                    pm.help();
                    break;
            }
        }
    }
}
