package com.vm.acaderp.controllers;

import com.vm.acaderp.dao.LoginDao;
import com.vm.acaderp.dao.impl.LoginDaoImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.*;

@Path("/login")
public class Login {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response validateEmployee(@FormParam("emp_id") String empId, @FormParam("password") String password) {
        LoginDao loginDao = new LoginDaoImpl();
        try {
            if(loginDao.validEmployee(empId, password)) {
                return Response.ok().build();
            } else {
                return Response.noContent().build();
            }
        } catch (Exception e) {
            Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
            Logger.getLogger("org.hibernate").log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
}
