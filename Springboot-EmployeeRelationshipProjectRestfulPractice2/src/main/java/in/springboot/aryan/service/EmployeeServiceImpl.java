package in.springboot.aryan.service;

import in.springboot.aryan.entity.Employee;
import in.springboot.aryan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> showAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee>optional= employeeRepository.findById(id);
        return optional.get();
    }

	

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		
	}

	


}
