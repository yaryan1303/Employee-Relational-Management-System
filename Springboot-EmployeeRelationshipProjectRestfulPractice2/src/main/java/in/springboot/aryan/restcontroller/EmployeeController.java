package in.springboot.aryan.restcontroller;

import in.springboot.aryan.entity.Employee;
import in.springboot.aryan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home()
    {
        return "message";
    }


    @GetMapping("/showEmpl")
    public List<Employee> showEmployee()
    {
        return employeeService.showAll();

    }
    @GetMapping("/showEmpl/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        try {
            Employee employeeById = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employeeById, HttpStatus.OK);  // Include the employee object in the response
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee,@PathVariable("id") Integer eid)
    {
        try {
            Employee employeeById = employeeService.getEmployeeById(eid);
            employeeById.setEname(employee.getEname());
            employeeById.setEage(employee.getEage());
            employeeById.setEaddress(employee.getEaddress());

            employeeService.saveEmployee(employeeById);
            return new ResponseEntity<>(employeeById,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id)
    {
    	employeeService.deleteEmployee(id);
    }
}
