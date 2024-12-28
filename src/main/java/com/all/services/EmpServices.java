package com.all.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all.entity.Employee;
import com.all.repository.EmpRepo;
@Service
public class EmpServices {
	 @Autowired
	private EmpRepo repo;
	
	
	public void addEmp(Employee e) {
		repo.save(e);
		
	}
	
	public List<Employee> allEmp(){
		return repo.findAll();
	}

	
	public Employee getEmpById(Integer id) {
		Optional<Employee>e=repo.findById(id);
		if(e.isPresent()) {
		return e.get();
		}
		else {
			return null;
		}
		
		
	}

	public void deleteEmpById(int id) {
	    // Check if the employee exists before attempting to delete
	    if (!repo.existsById(id)) {
	        throw new IllegalArgumentException("Employee with ID " + id + " does not exist.");
	    }

	    // Delete the employee if they exist
	    repo.deleteById(id);
	}

}
