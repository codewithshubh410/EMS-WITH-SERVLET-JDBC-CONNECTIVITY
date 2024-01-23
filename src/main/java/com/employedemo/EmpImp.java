package com.employedemo;

import java.util.List;

public interface EmpImp 
{
  public int saveEmp(Employee e);
  public int updateEmp(Employee e);
  public int deleteEmp(int id);
  public Employee getEmp(int id);
  public List<Employee>getAllEmp();
  
}
