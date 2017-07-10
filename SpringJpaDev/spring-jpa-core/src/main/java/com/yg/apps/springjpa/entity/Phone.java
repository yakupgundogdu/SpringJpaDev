package com.yg.apps.springjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yakup on 08.07.2017.
 */
@Entity
@Table(name = "tb_phone")
public class Phone implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "phone", unique = true, nullable = false, length = 10)
    private String phone;

    @Column(name = "employee_id",insertable=false, updatable=false)
    private long employeeId;

    /** USED
     * Bidirectional Relationship for Employee (O)-(M) Phone
     * Employee.java => @OneToMany(mappedBy="employee")
     *                  BECAUSE employee variable in Phone class
     * Phone.java => private Employee employee
     **/
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    /** UNUSED
     * Unidirectional Relationship for Employee (O)-(M) Phone
     * Employee.java => ------
     * Phone.java =>@ManyToOne(optional = false)
     *              @JoinColumn(name = "employee_id", referencedColumnName = "id")
     *              private Employee employee;
     **/

    public Phone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
