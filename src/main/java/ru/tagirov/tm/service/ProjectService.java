package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.repository.ProjectRepository;

import java.util.Map;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(final ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Map<String, Project> findAll(){
        return projectRepository.findAll();
    }

    public Project findOne(Project project){
        return projectRepository.findOne(project);
    }

    public void persist(final Project project){
        if (project == null){
            System.out.println("YOU TASK IS IVALID!");
        }
        else if (project.getName() == null || project.getDescription() == null || project.getDateCreate() == null){
            System.out.println("YOU VALUES IS INVALID!");
        }
        else if (project.getName().equals("") || project.getDescription().equals("") || project.getDateCreate().equals("")){
            System.out.println("YOU VALUES IS INVALID!");
        }else {
            projectRepository.persist(project);
        }
    }

    public Project merge(final Project project){
        if (project == null){
            System.out.println("YOU TASK IS IVALID!");
        }
        else if (project.getName() == null || project.getDescription() == null || project.getDateCreate() == null){
            System.out.println("YOU VALUES IS INVALID!");
        }
        else if (project.getName().equals("") || project.getDescription().equals("") || project.getDateCreate().equals("")){
            System.out.println("YOU VALUES IS INVALID!");
        }else {
            projectRepository.persist(project);
        }
        return projectRepository.merge(project);
    }

    public void remove(Project project){
        projectRepository.remove(project);
    }

    public void removeAll(){
        projectRepository.removeAll();
    }
}
