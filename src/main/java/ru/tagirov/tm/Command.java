package ru.tagirov.tm;

public enum Command {
    PROJECT_CREATE("project-create", "create a new project"),
    PROJECT_UPDATE("project-update", "update a project"),
    PROJECT_LIST("project-list", "show all project"),
    PROJECT_REMOVE("project-remove", "delete a project"),
    PROJECT_CLEAR("project-clear", "delete all project"),
    TASK_CREATE("task-create", "create a new task"),
    TASK_CREATE_TO_PROJECT("task-create-to-project", "create a new task in the project"),
    TASK_UPDATE("task-update", "update a task"),
    TASK_UPDATE_TO_PROJECT("task-update-to-project", "update a task in the project"),
    TASK_LIST("task-list", "show all task"),
    TASK_LIST_TO_PROJECT("task-list-to-project", "show all task in the project"),
    TASK_REMOVE("task-remove", "delete a task"),
    TASK_REMOVE_TO_PROJECT("task-remove-to-project", "delete a task in the project."),
    TASK_CLEAR("task-clear", "delete all task"),
    TASK_CLEAR_TO_PROJECT("task-clear-to-project", "delete all task in the project"),
    TASK_ADD_TO_PROJECT("task-add-to-project", "add a task to the project"),
    LIST_ALL("list-all", "show all"),
    CLEAR_ALL("clear-all", "delete all"),
    HELP("help", "Show all commands");

    String title;
    String description;

    Command(String title, String description){
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Command{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
