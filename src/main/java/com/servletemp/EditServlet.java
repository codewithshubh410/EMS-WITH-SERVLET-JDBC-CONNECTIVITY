package com.servletemp;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.employedemo.EmployDAO;
import com.employedemo.Employee;


public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public EditServlet() {
        super();
      
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 EmployDAO obj=new  EmployDAO();
		 PrintWriter out=response.getWriter();	
		 out.write("<h1> Update Employee</h1>");
		String str=request.getParameter("id");
         int eid=Integer.parseInt(str);
         
         Employee e=obj.getEmp(eid);
         
         out.write("<form action='EditServlet2'method='post'>");
         out.write("<table>");
         out.write("<tr><td>Id</td><td><input type='text' name='empid' value='"+e.getId()+"'/></td></tr>");
         out.write("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+" '/></td></tr>");
         out.write("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+" '/></td></tr>");
         out.write("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+" '/></td></tr>");
         out.write("<tr><td>Country</td><td>");
         out.write("<select name='country' style='width:150px'>");
         out.write("<option>India</option>");
         out.write("<option>UK</option>");
         out.write("<option>USA</option>");
         out.write("</select>");
         out.write("</td></tr>");
         out.write("<tr><td colspan='2'><input type='submit'value='edit&save'/></td><tr>");
         out.write("</table>");
         out.write("</form>");
	}

}
