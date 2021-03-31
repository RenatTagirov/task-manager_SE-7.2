package ru.tagirov.tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static final String PROJECT_CREATE = "project-create";
    private static final String PROJECT_UPDATE = "project-update";
    private static final String PROJECT_LIST = "project-list";
    private static final String PROJECT_REMOVE = "project-remove";
    private static final String PROJECT_CLEAR = "project-clear";

    private static final String TASK_CREATE = "task-create";
    private static final String TASK_CREATE_TO_PROJECT = "task-create-to-project";
    private static final String TASK_UPDATE = "task-update";
    private static final String TASK_UPDATE_TO_PROJECT = "task-update-to-project";
    private static final String TASK_LIST = "task-list";
    private static final String TASK_LIST_TO_PROJECT = "task-list-to-project";
    private static final String TASK_REMOVE = "task-remove";
    private static final String TASK_REMOVE_TO_PROJECT = "task-remove-to-project";
    private static final String TASK_CLEAR = "task-clear";
    private static final String TASK_CLEAR_TO_PROJECT = "task-clear-to-project";
    private static final String TASK_ADD_TO_PROJECT = "task-add-to-project";

    private static final String LIST_ALL = "list-all";
    private static final String CLEAR_ALL = "clear-all";
    private static final String HELP = "help";



    public static void main( String[] args ) throws IOException {
        ProjectManager pm = new ProjectManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while(!(command= reader.readLine()).equalsIgnoreCase("EXIT")){
            switch(command){
                case (PROJECT_CLEAR):
                    pm.projectClear();
                    break;
                case (PROJECT_CREATE):
                    pm.projectCreate();
                    break;
                case (PROJECT_UPDATE):
                    pm.projectUpdate();
                    break;
                case (PROJECT_LIST):
                    pm.projectList();
                    break;
                case (PROJECT_REMOVE):
                    pm.projectRemove();
                    break;
                case (TASK_CREATE):
                    pm.taskCreate();
                    break;
                case (TASK_CREATE_TO_PROJECT):
                    pm.taskCreateToProject();
                    break;
                case (TASK_UPDATE):
                    pm.taskUpdate();
                    break;
                case (TASK_UPDATE_TO_PROJECT):
                    pm.taskUpdateToProject();
                    break;
                case (TASK_LIST):
                    pm.taskList();
                    break;
                case (TASK_LIST_TO_PROJECT):
                    pm.taskListToProject();
                    break;
                case (TASK_REMOVE):
                    pm.taskRemove();
                    break;
                case (TASK_REMOVE_TO_PROJECT):
                    pm.taskRemoveToProject();
                    break;
                case (TASK_CLEAR):
                    pm.taskClear();
                    break;
                case TASK_CLEAR_TO_PROJECT:
                    pm.taskClearToProject();
                    break;
                case TASK_ADD_TO_PROJECT:
                    pm.taskAddToProject();
                    break;
                case (LIST_ALL):
                    pm.listAll();
                    break;
                case (CLEAR_ALL):
                    pm.clearAll();
                    break;
                case (HELP):
                    pm.help();
                    break;
            }
        }
    }
}
