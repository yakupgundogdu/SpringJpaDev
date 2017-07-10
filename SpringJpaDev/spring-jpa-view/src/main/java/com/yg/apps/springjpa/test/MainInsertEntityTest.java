package com.yg.apps.springjpa.test;

import com.yg.apps.springjpa.entity.*;
import com.yg.apps.springjpa.service.department.IDepartmentService;
import com.yg.apps.springjpa.service.employee.IEmployeeService;
import com.yg.apps.springjpa.service.idcard.IIdCardService;
import com.yg.apps.springjpa.service.phone.IPhoneService;
import com.yg.apps.springjpa.service.project.IProjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by yakup on 10.07.2017.
 */
public class MainInsertEntityTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        IDepartmentService departmentService = (IDepartmentService) ctx.getBean("departmentService");
        IIdCardService idCardService = (IIdCardService) ctx.getBean("idCardService");
        IEmployeeService employeeService = (IEmployeeService) ctx.getBean("employeeService");
        IPhoneService phoneService = (IPhoneService) ctx.getBean("phoneService");
        IProjectService projectService = (IProjectService) ctx.getBean("projectService");

        // IDCARDDDDD
        IdCard idc1 = new IdCard();
        idc1.setSerialNumber(UUID.randomUUID().toString().substring(0, 16));
        idCardService.addIdCard(idc1);

        IdCard idc2 = new IdCard();
        idc2.setSerialNumber(UUID.randomUUID().toString().substring(0, 16));
        idCardService.addIdCard(idc2);

        IdCard idc3 = new IdCard();
        idc3.setSerialNumber(UUID.randomUUID().toString().substring(0, 16));
        idCardService.addIdCard(idc3);

        // DEPARTMENTTTTTT
        Department dep1 = new Department();
        dep1.setName("SOFTWARE DEVELOPMENT");
        departmentService.addEmployee(dep1);

        Department dep2 = new Department();
        dep2.setName("SALES");
        departmentService.addEmployee(dep2);

        Department dep3 = new Department();
        dep3.setName("MARKETING");
        departmentService.addEmployee(dep3);

        // EMPLOYEEEEE
        Employee emp1 = new Employee();
        emp1.setFirstName("YAKUP");
        emp1.setLastName("GUNDOGDU");
        emp1.setEmail("yakup@gmail.com");
        //        emp1.setIdCardId(1l);
        //        emp1.setDepartmentId(1l);
        emp1.setIdCard(idCardService.getIdCardWithId(1));
        emp1.setDepartment(departmentService.getDepartmentWithId(1));
        employeeService.addEmployee(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("YASAR");
        emp2.setLastName("MATRAC");
        emp2.setEmail("yasar@gmail.com");
        //        emp2.setIdCardId(1l);
        //        emp2.setDepartmentId(1l);
        emp2.setIdCard(idCardService.getIdCardWithId(2));
        emp2.setDepartment(departmentService.getDepartmentWithId(1));
        employeeService.addEmployee(emp2);

        Employee emp3 = new Employee();
        emp3.setFirstName("MAHMUT");
        emp3.setLastName("TUNCER");
        emp3.setEmail("mahmut@gmail.com");
        //        emp3.setIdCardId(1l);
        //        emp3.setDepartmentId(1l);
        emp3.setIdCard(idCardService.getIdCardWithId(3));
        emp3.setDepartment(departmentService.getDepartmentWithId(3));
        employeeService.addEmployee(emp3);


        // PHONEEEE
        Phone phone1 = new Phone();
        phone1.setPhone("5382049429");
        phone1.setEmployee(employeeService.getEmployeeWithId(1));
        phoneService.addPhone(phone1);

        Phone phone2 = new Phone();
        phone2.setPhone("5382012121");
        phone2.setEmployee(employeeService.getEmployeeWithId(1));
        phoneService.addPhone(phone2);

        Phone phone3 = new Phone();
        phone3.setPhone("5379991122");
        phone3.setEmployee(employeeService.getEmployeeWithId(2));
        phoneService.addPhone(phone3);

        Phone phone4 = new Phone();
        phone4.setPhone("5379993131");
        phone4.setEmployee(employeeService.getEmployeeWithId(3));
        phoneService.addPhone(phone4);

        Project p1 = new Project();
        p1.setName("FINANCE PROJECT");
        List<Employee> financeEmployeeList = new ArrayList<>();
        financeEmployeeList.add(employeeService.getEmployeeWithId(1));
        financeEmployeeList.add(employeeService.getEmployeeWithId(3));
        p1.setEmployeeList(financeEmployeeList);
        projectService.addProject(p1);

        Project p2 = new Project();
        p2.setName("SERVICE PROJECT");
        List<Employee> serviceEmployeeList = new ArrayList<>();
        serviceEmployeeList.add(employeeService.getEmployeeWithId(1));
        serviceEmployeeList.add(employeeService.getEmployeeWithId(2));
        p2.setEmployeeList(serviceEmployeeList);
        projectService.addProject(p2);

        Project p3 = new Project();
        p3.setName("MOBILE PROJECT");
        List<Employee> mobileEmployeeList = new ArrayList<>();
        mobileEmployeeList.add(employeeService.getEmployeeWithId(2));
        mobileEmployeeList.add(employeeService.getEmployeeWithId(3));
        p3.setEmployeeList(mobileEmployeeList);
        projectService.addProject(p3);

    }
}
