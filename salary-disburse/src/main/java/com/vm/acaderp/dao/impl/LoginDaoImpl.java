package com.vm.acaderp.dao.impl;

import com.vm.acaderp.dao.LoginDao;
import com.vm.acaderp.models.Employee;
import com.vm.acaderp.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDaoImpl implements LoginDao {
    public static String ACC_DEPT = "AC";

    @Override
    public boolean validEmployee(String empId, String password) {
        if(empId.length() < 2) {
            return false;
        }
        if(!empId.substring(0,2).equals(LoginDaoImpl.ACC_DEPT)) {
            return false;
        }

        Employee emp;
        boolean valid = false;

        Session session = SessionUtil.getSession();
        Transaction txn = session.beginTransaction();
        emp = session.get(Employee.class, empId);
        if(password.equals(emp.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
