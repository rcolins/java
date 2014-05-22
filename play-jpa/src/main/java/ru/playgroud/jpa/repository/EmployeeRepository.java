package ru.playgroud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.playgroud.jpa.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  
}
