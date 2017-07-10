package com.yg.apps.springjpa.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yakup on 08.07.2017.
 */
@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 32)
    private String email;

    //Optional Column. For understandable relationships.
    @Column(name = "id_card_id", insertable = false, updatable = false)
    private long idCardId;

    //Optional Column. For understandable relationships.
    @Column(name = "department_id", insertable = false, updatable = false)
    private long departmentId;


    /************************* USED ***********************
     * Unidirectional Relationship for Employee (O)-(O) IdCard
     * Employee.java => @JoinColumn(name = "id_card_id")
     *                  BECAUSE id_card_id in this table
     * IdCard.java => --------
     **/
    @OneToOne(optional = false)
    @JoinColumn(name = "id_card_id")
    private IdCard idCard;
    /************************* UN-USED ***********************
     * Bidirectional Relationship for Employee (O)-(O) IdCard
     * Employee.java => private IdCard idCard;
     * IdCard.java => Go to IdCard class
     **/


    /************************* USED ***********************
     * Bidirectional Relationship for Employee (O)-(M) Phone
     * Employee.java => @OneToMany(mappedBy="employee")
     *                  BECAUSE employee variable in Phone class
     * Phone.java => Go to Phone class
     **/
    @OneToMany(mappedBy="employee", targetEntity=Phone.class, fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT) //For prevent dublicate list for entityManager.find() method
    private List<Phone> phoneList;
    /************************* UN-USED ***********************
     * Unidirectional Relationship for Employee (O)-(M) Phone
     * Employee.java => ------
     * Phone.java => Go to Phone class
     **/

    /************************* USED ***********************
     * Unidirectional Relationship for Employee (M)-(O) Department
     * Employee.java => @JoinColumn(name = "department_id", referencedColumnName="id")
     *                  BECAUSE department_id in this table and primary key in owner table as "id"
     * IdCard.java => ------
     **/
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    /************************* UN-USED ***********************
     * Bidirectional Relationship for Employee (M)-(O) Department
     * Employee.java => private Department department;
     * Phone.java => Go to Department class
     **/

    /************************* USED ***********************
     * Unidirectional Relationship for Employee (M)-(M) Project
     * Employee.java => @ManyToMany(mappedBy = "employeeList", fetch = FetchType.EAGER)
     *                  BECAUSE employeeList variable in Project class
     * Project.java => Go to Project class
     **/
    @ManyToMany(mappedBy = "employeeList", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT) //For prevent dublicate list for entityManager.find() method
    private List<Project> projectList;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(long idCardId) {
        this.idCardId = idCardId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
