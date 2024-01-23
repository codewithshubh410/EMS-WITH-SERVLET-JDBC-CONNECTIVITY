package com.servletemp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.employedemo.EmployDAO;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EmployDAO obj=new  EmployDAO();
		 int eid=Integer.parseInt(request.getParameter("id"));
		 obj.deleteEmp(eid);
		 response.sendRedirect("ViewServlet");
	}
}
