package org.iiitb.bean;

import javax.persistence.*;

@Entity
@Table(name = "salary_master")
public class SalaryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee e_Id;

    @Column(name = "sal_amt")
    private int salaryAmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmpId() {
        return e_Id;
    }

    public void setEmpId(Employee emp) {
        this.e_Id = emp;
    }

    public int getSalaryAmt() {
        return salaryAmt;
    }

    public void setSalaryAmt(int salaryAmt) {
        this.salaryAmt = salaryAmt;
    }

    @Override
    public String toString() {
        return "SalaryMaster{" +
                "id=" + id +
                ", e_Id =" + e_Id.toString() +
                ", salaryAmt=" + salaryAmt +
                '}';
    }
}
