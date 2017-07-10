package com.yg.apps.springjpa.service.employee.impl;

import com.yg.apps.springjpa.dao.employee.IEmployeeDao;
import com.yg.apps.springjpa.entity.Employee;
import com.yg.apps.springjpa.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService implements IEmployeeService{

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public List<Employee> getEmployeesWithDepartmentId(long departmentId)  {
        return employeeDao.getEmployeesWithDepartmentId(departmentId);
    }

    @Override
    public Employee getEmployeeWithId(long id) {
        return employeeDao.getEmployeeWithId(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }
}
