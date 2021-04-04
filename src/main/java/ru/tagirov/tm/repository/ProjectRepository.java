package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.Project;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectRepository {
    private Map<String, Project> projectMap = new LinkedHashMap<>();

    public Map<String, Project> findAll(){
        return projectMap;
    }

    public Project findOne(Project project){
        return projectMap.get(project.getId());
    }

    public void persist(final Project project){
        projectMap.put(project.getId(), project);
    }

    public Project merge(final Project project){
        projectMap.put(project.getId(), project);
        return projectMap.get(project.getId());
    }

    public void remove(Project project){
        projectMap.remove(project.getId());
    }

    public void removeAll(){
        projectMap.clear();
    }

}
