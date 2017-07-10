package com.yg.apps.springjpa.dao.project;

import com.yg.apps.springjpa.entity.Project;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
public interface IProjectDao {

    List<Project> getAllProjects();

    Project getProjectWithId(long id);

    void addProject(Project project);

    void updateProject(Project project);
}
