package com.servletemp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.employedemo.EmployDAO;
import com.employedemo.Employee;

public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet2() {
        super();
        
    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     EmployDAO obj=new  EmployDAO();
	     PrintWriter pw=response.getWriter();
	     
	     String sid=request.getParameter("empid");
		 int eid=Integer.parseInt(sid);
		 String name=request.getParameter("name");
		 String pass=request.getParameter("password");
		 String  mail=request.getParameter("email");
		 String country=request.getParameter("country");
		 
		
		 Employee e=new Employee();
		 
		 e.setId(eid);
		 e.setName(name);
		 e.setPassword(pass);
		 e.setEmail(mail);
		 e.setCountry(country);
		
		 int status=obj.updateEmp(e);
        if(status>0)
        {
       	 response.sendRedirect("ViewServlet");
        }
        else
        {
       	 pw.write("Sorry! upadation Failed");
        }
	}

}
