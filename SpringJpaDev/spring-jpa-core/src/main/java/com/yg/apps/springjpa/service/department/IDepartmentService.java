package com.yg.apps.springjpa.service.department;

import com.yg.apps.springjpa.entity.Department;

import java.util.List;

/**
 * Created by yakup on 09.07.2017.
 */
public interface IDepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentWithId(long id);

    void addEmployee(Department department);

    void updateEmployee(Department department);
}
