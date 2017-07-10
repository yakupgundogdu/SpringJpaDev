package com.yg.apps.springjpa.service.project.impl;

import com.yg.apps.springjpa.dao.project.IProjectDao;
import com.yg.apps.springjpa.entity.Project;
import com.yg.apps.springjpa.service.project.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectService implements IProjectService{

    @Autowired
    private IProjectDao projectDao;

    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public Project getProjectWithId(long id) {
        return projectDao.getProjectWithId(id);
    }

    @Override
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }
}
