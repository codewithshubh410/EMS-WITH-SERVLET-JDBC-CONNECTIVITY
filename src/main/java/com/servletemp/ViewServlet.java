package com.servletemp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.employedemo.EmployDAO;
import com.employedemo.Employee;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 EmployDAO obj=new  EmployDAO();
		 PrintWriter out=response.getWriter();
		 List<Employee>list=obj.getAllEmp();
		 
		 out.write("<a href='EmployProj.html'>Add New Employe</a>");
		 out.write("<h1> Employee List</h1>");
		 out.write("<table width='500px' border='1'>");
		 out.write("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		 for(Employee e:list)                                                                                                                                                                                   
		 {
			out.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"+"<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		 }
			out.write("</table>");
	     }
}
	
