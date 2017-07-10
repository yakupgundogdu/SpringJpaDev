package com.yg.apps.springjpa.test;

import com.yg.apps.springjpa.entity.*;
import com.yg.apps.springjpa.service.department.IDepartmentService;
import com.yg.apps.springjpa.service.employee.IEmployeeService;
import com.yg.apps.springjpa.service.idcard.IIdCardService;
import com.yg.apps.springjpa.service.phone.IPhoneService;
import com.yg.apps.springjpa.service.project.IProjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
public class MainSelectEntityTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        IDepartmentService departmentService = (IDepartmentService) ctx.getBean("departmentService");
        IIdCardService idCardService = (IIdCardService) ctx.getBean("idCardService");
        IEmployeeService employeeService = (IEmployeeService) ctx.getBean("employeeService");
        IPhoneService phoneService = (IPhoneService) ctx.getBean("phoneService");
        IProjectService projectService = (IProjectService) ctx.getBean("projectService");

        Employee employee1 = employeeService.getEmployeeWithId(1);
        IdCard idIdCard1 = employee1.getIdCard();
        Department department1 = departmentService.getDepartmentWithId(employee1.getDepartmentId());

        //OneToOne (Employee (O)-(O) IdCard)
        System.out.println("\n@OneToOne:");
        System.out.println("Employee1:" + employee1.getFirstName() + " " + employee1.getLastName());
        System.out.println("Employee1-IdCard1: IdCard_Id(" + idIdCard1.getId()+ ") IdCard_SerialNumber(" + idIdCard1.getSerialNumber() + ")");

        //OneToMany (Employee (O)-(M) Phone) Also ManyToOne in its
        System.out.println("\n@OneToMany:");
        System.out.println("Employee1:" + employee1.getFirstName() + " " + employee1.getLastName());
        for(Phone p : employee1.getPhoneList() ){
            System.out.println("Employee1-Phone" + p.getId() + ":" + p.getPhone());
        }

        //ManyToOne (Employee (M)-(O) Department)
        System.out.println("\n@ManyToOne:");
        List<Employee> employeeList = employeeService.getEmployeesWithDepartmentId(department1.getId());
        for(Employee e : employeeList){
            System.out.println("Employee" + e.getId()+ ":" + e.getFirstName() + " " + e.getLastName());
        }
        System.out.println("Department1: Department_Id(" + department1.getId() + ") Department_Name(" + department1.getName() +")");

        //ManyToMany (Employee (M)-(M) Project)
        System.out.println("\n@ManyToMany:");
        List<Employee> employees = employeeService.getAllEmployees();
        List<Project> projects = projectService.getAllProjects();
        System.out.println("FROM EMPLOYEES LIST:");
        for(Employee e : employees){
            System.out.println("Employee" + e.getId()+ ":" + e.getFirstName() + " " + e.getLastName());
            for(Project p : e.getProjectList()){
                System.out.println("Employee" + e.getId()+ "-Project" + p.getId() + ": " + p.getName());
            }
        }
        System.out.println("\nFROM PROJECTS LIST:");
        for(Project p : projects){
            System.out.println("Project" + p.getId() + ": " + p.getName());
            for(Employee e : p.getEmployeeList()){
                System.out.println("Project" + p.getId()+ "-Employee" + e.getId() + ": " + e.getFirstName() + " " + e.getLastName());
            }
        }

    }
}
