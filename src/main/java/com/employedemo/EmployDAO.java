package com.employedemo;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO implements EmpImp
{
	@Override
	public int saveEmp(Employee e) {
		int status=0;
		try
		{
			Connection con=DataConnection.useConnection();
			PreparedStatement ps=con.prepareStatement("insert into  employedetail values(?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setString(3,e.getPassword());
			ps.setString(4,e.getEmail());
			ps.setString(5,e.getCountry());
			
			status=ps.executeUpdate();
		}
		catch(Exception e1)
		{
			e1.toString();
		}
			return status;
		
		
	}

	@Override
	public int updateEmp(Employee e) 
	{
		int status=0;
		try
		{
		Connection con=DataConnection.useConnection();
		PreparedStatement ps=con.prepareStatement("update employedetail set Name=?,Password=?,Email=?,Country=? where Id=?");
	    ps.setString(1,e.getName());
	    ps.setString(2,e.getPassword());
	    ps.setString(3,e.getEmail());
	    ps.setString(4,e.getCountry());
	    ps.setInt(5,e.getId());
	    
	    status=ps.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.toString();
		}
		return status;
	}

	@Override
	public int deleteEmp(int id) 
	{
		int status=0;
		try
		{
			Connection con=DataConnection.useConnection();
			PreparedStatement ps=con.prepareStatement("delete from employedetail where Id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e3)
		{
			e3.toString();
		}
		return status;
	}

	@Override
	public Employee getEmp(int id) 
	{
		Employee obj=new Employee();
		try
		{
			Connection con=DataConnection.useConnection();
			PreparedStatement ps=con.prepareStatement("select * from employedetail where Id=?");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPassword(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setCountry(rs.getString(5));
			}
		}
		catch(Exception e4)
		{
			e4.toString();
		}
		return obj;
	}

	@Override
	public List<Employee> getAllEmp() 
	{
	 List<Employee>list=new ArrayList<>();
	 try
	 {
		 Connection con=DataConnection.useConnection();
		 PreparedStatement ps=con.prepareStatement("select * from employedetail");
		 ResultSet rs=ps.executeQuery();
		 
		 while(rs.next())
		 {
			 Employee obj=new Employee();
			 obj.setId(rs.getInt(1));
	         obj.setName(rs.getString(2));
		     obj.setPassword(rs.getString(3));
			 obj.setEmail(rs.getString(4));
			 obj.setCountry(rs.getString(5));
			 list.add(obj);			 
		 }
	 }
	 catch(Exception e5)
	 {
		 e5.toString();
	 }
		return list;
	}

}
