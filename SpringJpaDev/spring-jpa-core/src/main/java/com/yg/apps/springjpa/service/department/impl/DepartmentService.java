package com.yg.apps.springjpa.service.department.impl;

import com.yg.apps.springjpa.dao.department.IDepartmentDao;
import com.yg.apps.springjpa.entity.Department;
import com.yg.apps.springjpa.service.department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yakup on 09.07.2017.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public Department getDepartmentWithId(long id) {
        return departmentDao.getDepartmentWithId(id);
    }

    @Override
    public void addEmployee(Department department) {
        departmentDao.addEmployee(department);
    }

    @Override
    public void updateEmployee(Department department) {
        departmentDao.updateEmployee(department);
    }
}
