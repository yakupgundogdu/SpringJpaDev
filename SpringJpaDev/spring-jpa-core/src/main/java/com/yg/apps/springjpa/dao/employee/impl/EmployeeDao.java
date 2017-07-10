package com.yg.apps.springjpa.dao.employee.impl;

import com.yg.apps.springjpa.dao.employee.IEmployeeDao;
import com.yg.apps.springjpa.entity.Department;
import com.yg.apps.springjpa.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Repository
public class EmployeeDao implements IEmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = entityManager.createQuery("Select a From Employee a", Employee.class).getResultList();
        return employees;
    }

    @Override
    public List<Employee> getEmployeesWithDepartmentId(long departmentId) {
        Query query = entityManager.createQuery("Select a From Employee a where a.departmentId = :department_id ", Employee.class);
        query.setParameter("department_id",departmentId);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployeeWithId(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }
}
