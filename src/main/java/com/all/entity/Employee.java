package com.all.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String name;
    private String address;
    private String email;
    private String phoneNo; // Matches the form's "phoneNo" field
    private double salary;

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', address='" + address + "', email='" + email + "', phoneNo='" + phoneNo + "', salary=" + salary + "}";
    }
}
