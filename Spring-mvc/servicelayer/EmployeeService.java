package com.example.demo.servicelayer;
import com.example.demo.Employee;
import org.hibernate.sql.Update;

import java.util.List;
public interface EmployeeService {
  Employee saveEmployee(Employee employee);
 List<Employee> getAllEmployee();
 Employee getEmployeeById(Long id);
  Employee updateEmployee(Long empid,Employee employee);

  Employee deleteEmployee(Long empid);
}
