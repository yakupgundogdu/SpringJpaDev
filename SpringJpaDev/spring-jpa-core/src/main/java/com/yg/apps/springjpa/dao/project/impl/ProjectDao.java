package com.yg.apps.springjpa.dao.project.impl;

import com.yg.apps.springjpa.dao.project.IProjectDao;
import com.yg.apps.springjpa.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Repository
public class ProjectDao implements IProjectDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = entityManager.createQuery("Select a From Project a", Project.class).getResultList();
        return projects;
    }

    @Override
    public Project getProjectWithId(long id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void addProject(Project project) {
        entityManager.persist(project);
    }

    @Override
    public void updateProject(Project project) {
        entityManager.merge(project);
    }
}
