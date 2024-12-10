package in.springboot.aryan.service;

import in.springboot.aryan.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public void saveEmployee(Employee employee);
    public List<Employee> showAll();

    public Employee getEmployeeById(Integer id);
    
    public void deleteEmployee(Integer id);
}
