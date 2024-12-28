package com.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.all.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

}
