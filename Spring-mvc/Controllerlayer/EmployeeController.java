package com.example.demo.Controllerlayer;
import com.example.demo.Employee;
import com.example.demo.servicelayer.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED) ;
}
    @GetMapping
    public List<Employee> getEmp(){
    return employeeService.getAllEmployee();
    }
    @GetMapping("{abc}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("abc") Long empid){
    return new ResponseEntity<Employee>(employeeService.getEmployeeById(empid),HttpStatus.LOOP_DETECTED
    );
    }
    @PutMapping("{id}")
    public ResponseEntity<String>updateEmployee(@PathVariable("id") Long empid,@RequestBody Employee employee) {
        employeeService.updateEmployee(empid, employee);
        return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
    }
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empid){
   // return  new ResponseEntity<Employee>(employeeService.deleteEmployee(empid), HttpStatus.OK);
    employeeService.deleteEmployee(empid);
   return  new ResponseEntity<String>("deleted successful", HttpStatus.OK);
    }

}
