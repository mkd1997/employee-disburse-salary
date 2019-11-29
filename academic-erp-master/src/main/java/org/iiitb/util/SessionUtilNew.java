package org.iiitb.util;

import org.iiitb.bean.Department;
import org.iiitb.bean.Employee;
import org.iiitb.bean.SalaryDisbursement;
import org.iiitb.bean.SalaryMaster;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import java.util.logging.*;

public class SessionUtilNew {

    public static Session getSession() throws HibernateException {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).addAnnotatedClass(SalaryMaster.class).addAnnotatedClass(SalaryDisbursement.class);
        Session session = cfg.buildSessionFactory().openSession();
        return session;
    }

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        Session session = cfg.buildSessionFactory().openSession();
        Transaction txn = session.beginTransaction();

        Department deptObj = new Department();
        deptObj.setDeptName("IITB");
        session.save(deptObj);
//        System.out.println("Hello World");
//        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
//        Logger.getLogger("org.hibernate").log(Level.WARNING, "Hello");
        session.getTransaction().commit();
        session.close();
    }
}
