package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Complaint;
import tn.esprit.entities.Employee;
import tn.esprit.repositories.ComplaintRepository;
import tn.esprit.repositories.EmployeeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private final EmployeeRepository employeeRepository;

	public EmployeServiceImpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmploye() {
		return employeeRepository.findAll();

	}

	@Override
	public Employee FindEmployeeById(int id) {
		Employee e = employeeRepository.findById(id).get();
		return e;
	}

}
