package com.yg.apps.springjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yakup on 08.07.2017.
 */
@Entity
@Table(name = "tb_department")
public class Department implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;

    /** USED
     * Unidirectional Relationship for Employee (M)-(O) Department
     * Employee.java => @JoinColumn(name = "department_id", referencedColumnName="id")
     *                  BECAUSE department_id in this table and primary key in owner table as "id"
     * Department.java => ------
     **/

    /** UNUSED
     * Bidirectional Relationship for [Employee (M)-(O) Department
     * Employee.java => private Department department;
     * Department.java => BECAUSE In Employee class Department Object variable defined as department
     *       @OneToMany( mappedBy = "department", targetEntity = Employee.class, fetch = FetchType.EAGER)
     *       private List<Employee> employees;
    **/
    public Department() {
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
}
