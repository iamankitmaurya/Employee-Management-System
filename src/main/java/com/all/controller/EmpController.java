package com.all.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.all.entity.Employee;
import com.all.services.EmpServices;

import jakarta.persistence.Id;

@Controller
public class EmpController {
	@Autowired
	private EmpServices services;
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<Employee>emp=services.allEmp();
		model.addAttribute("emp",emp);
		
		return "index";
		
	}
	@GetMapping("/addemp")
	public String addEmp() {
		return "addemp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, Model model) {
		System.out.println(e);
		services.addEmp(e);
		 model.addAttribute("msg","Employee added successfully");
	    
	    return "redirect:/"; // Ensure "addemp" corresponds to an existing Thymeleaf template
	}
	
	@GetMapping("/edit/{id}")
	public String empEdit(@PathVariable Integer id, Model model) {
	   Employee empById = services.getEmpById(id);
	    model.addAttribute("emp", empById);
	    return "edit";
	}

	
	@PostMapping("/update")
	public String empUpadate(@ModelAttribute Employee e) {
		services.addEmp(e);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
	    // Call the service layer to delete the employee
	    services.deleteEmpById(id);
	    
	    // Redirect to the home or list page after deletion
	    return "redirect:/";  // Change to the appropriate path, e.g., "redirect:/list"
	}


	
	

}
