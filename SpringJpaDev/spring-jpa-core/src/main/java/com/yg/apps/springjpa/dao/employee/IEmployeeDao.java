package com.yg.apps.springjpa.dao.employee;

import com.yg.apps.springjpa.entity.Employee;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
public interface IEmployeeDao {

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesWithDepartmentId(long departmentId);

    Employee getEmployeeWithId(long id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
