package com.vm.acaderp.util;

import com.vm.acaderp.models.Department;
import com.vm.acaderp.models.Employee;
import com.vm.acaderp.models.SalaryDisbursement;
import com.vm.acaderp.models.SalaryMaster;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import java.util.logging.*;

public class SessionUtil {

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
