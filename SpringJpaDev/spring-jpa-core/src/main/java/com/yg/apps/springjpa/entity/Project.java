package com.yg.apps.springjpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yakup on 08.07.2017.
 */
@Entity
@Table(name = "tb_project")
public class Project implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    /************************* USED ***********************
     * Unidirectional Relationship for Employee (M)-(M) Project
     * Employee.java => @ManyToMany(mappedBy = "employeeList", fetch = FetchType.EAGER)
     *                  BECAUSE employeeList variable in Project class
     * Project.java => Join Table for "tb_project_employee" and
     **/
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="tb_project_employee",
            joinColumns = @JoinColumn(name="project_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="employee_id", referencedColumnName="id"))
    private List<Employee> employeeList;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
