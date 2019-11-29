package org.iiitb.bean;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "emp_id", unique = true)
    private String empId;

    @OneToOne(mappedBy = "e_Id", cascade = CascadeType.ALL)
    private SalaryMaster salMaster;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department dept;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
    Set<SalaryDisbursement> salTxnSet = new HashSet<SalaryDisbursement>();

    public Employee(String empId, String empName, String password, Department dept) {
        this.empId = empId;
        this.empName = empName;
        this.password = password;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", salMaster=" + salMaster +
                ", empName='" + empName + '\'' +
                ", password='" + password + '\'' +
                ", dept=" + dept +
                ", salTxnSet=" + salTxnSet +
                '}';
    }
}
