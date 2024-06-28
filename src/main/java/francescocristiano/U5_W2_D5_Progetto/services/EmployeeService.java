package francescocristiano.U5_W2_D5_Progetto.services;

import francescocristiano.U5_W2_D5_Progetto.entities.Employee;
import francescocristiano.U5_W2_D5_Progetto.exceptions.BadRequestException;
import francescocristiano.U5_W2_D5_Progetto.exceptions.NotFoundException;
import francescocristiano.U5_W2_D5_Progetto.payloads.NewEmployeeDTO;
import francescocristiano.U5_W2_D5_Progetto.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(NewEmployeeDTO employeePayload) {
        employeeRepository.findByUsername(employeePayload.username()).ifPresent(employee -> {
            throw new BadRequestException("Username already exists");
        });
        Employee newEmployee = new Employee(employeePayload.username(), employeePayload.name(), employeePayload.surname(), employeePayload.email());
        return employeeRepository.save(newEmployee);
    }

    public Employee findEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Page<Employee> findAllEmployees(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    public Employee findEmployeeByIdAndUpdate(UUID id, NewEmployeeDTO updatedEmployeePayload) {
        Employee updatedEmployee = new Employee(updatedEmployeePayload.username(), updatedEmployeePayload.name(), updatedEmployeePayload.surname(), updatedEmployeePayload.email());
        Employee foundEmployee = findEmployeeById(id);
        foundEmployee.setUsername(updatedEmployee.getUsername());
        foundEmployee.setName(updatedEmployee.getName());
        foundEmployee.setSurname(updatedEmployee.getSurname());
        foundEmployee.setEmail(updatedEmployee.getEmail());
        foundEmployee.setAvatarUrl(updatedEmployee.getAvatarUrl());
        return employeeRepository.save(foundEmployee);
    }

    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteById(id);
    }
}
