package com.employedemo;
import java.sql.*;
public class DataConnection 
{
   public static Connection useConnection()
   {
	   Connection con=null;
	   try
	   {
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","shubhangi410");
	   }
	   catch(Exception e)
	   {
		   e.toString();
	   }
	   
	   return con;
   }
}