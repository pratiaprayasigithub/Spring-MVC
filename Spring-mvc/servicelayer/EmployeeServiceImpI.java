package com.example.demo.servicelayer;
import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import com.example.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpI implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpI(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id) {
      Optional<Employee> employee = employeeRepository.findById(id);
      if(employee.isPresent()){
          return employee.get();
      }else {
          throw new ResourceNotFoundException("Employee","ID",id);
      }
    }

    @Override
    public Employee updateEmployee(Long empid, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(empid).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", empid));
        oldEmployee.setFirstname(employee.getFirstname());
        oldEmployee.setLastname(employee.getLastname());
        oldEmployee.setEmail(employee.getEmail());
        employeeRepository.save(oldEmployee);
        return oldEmployee;
    }
        public Employee deleteEmployee(Long empid){

        employeeRepository.deleteById(empid);
        return null;

    }
}
