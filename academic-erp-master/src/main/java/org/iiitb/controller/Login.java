package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.dao.LoginDao;
import org.iiitb.dao.impl.LoginDaoImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.*;

@Path("/login")
public class Login {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public Response validateEmployee(@FormDataParam("emp_id") String empId, @FormDataParam("password") String password) {
        LoginDao loginDao = new LoginDaoImpl();
        try {
            if(loginDao.validEmployee(empId, password)) {
                return Response.ok().build();
            } else {
                return Response.seeOther(new URI("../data.html")).build();
            }
        } catch (Exception e) {
            Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
            Logger.getLogger("org.hibernate").log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
}
