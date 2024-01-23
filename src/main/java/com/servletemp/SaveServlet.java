package com.servletemp;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.employedemo.EmployDAO;
import com.employedemo.Employee;
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaveServlet() {
        super();
   
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 EmployDAO obj=new  EmployDAO();
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 int id=Integer.parseInt(request.getParameter("empid"));
		 String name=request.getParameter("name");
		 String pass=request.getParameter("pass");
		 String  mail=request.getParameter("mail");
		 String country=request.getParameter("contry");
		
		 Employee e=new Employee();
		
		 
		 e.setId(id);
		 e.setName(name);
		 e.setPassword(pass);
		 e.setEmail(mail);
		 e.setCountry(country);
		 
		 int status=obj.saveEmp(e);
            
		 if(status>0)
		 {
			 out.print("<h2> Record Saved Successfully </h2>");
			 request.getRequestDispatcher("EmployProj.html").include(request,response);
		 }
		 else
		 {
			 out.print("<h2> Sorry ! Unable to save Record </h2>");
		 }
	}

}
