package com.yg.apps.springjpa.dao.department.impl;

import com.yg.apps.springjpa.dao.department.IDepartmentDao;
import com.yg.apps.springjpa.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yakup on 09.07.2017.
 */
@Repository
public class DepartmentDao implements IDepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> getAllDepartments() {
        List<Department> depts = entityManager.createQuery("Select a From Department a", Department.class).getResultList();
        return depts;
    }

    @Override
    public Department getDepartmentWithId(long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public void addEmployee(Department department) {
        entityManager.persist(department);
    }

    @Override
    public void updateEmployee(Department department) {
        entityManager.merge(department);
//        entityManager.flush();
//        entityManager.refresh(department);
    }
}
