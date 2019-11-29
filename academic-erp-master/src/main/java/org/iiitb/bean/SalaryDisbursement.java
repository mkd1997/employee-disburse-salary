package org.iiitb.bean;

import javax.persistence.*;

@Entity
@Table(name = "salary_disburse")
public class SalaryDisbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "amount_paid")
    private int amtPaid;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee emp;

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

    public int getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(int amtPaid) {
        this.amtPaid = amtPaid;
    }

    @Override
    public String toString() {
        return "SalaryDisbursement{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", amtPaid=" + amtPaid +
                '}';
    }
}
