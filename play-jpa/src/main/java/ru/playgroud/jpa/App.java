package ru.playgroud.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.playgroud.jpa.boot.ApplicationConfiguration;
import ru.playgroud.jpa.model.Employee;
import ru.playgroud.jpa.repository.EmployeeRepository;

/**
 * Hello world!
 * 
 */
public class App {
  public static void main(String[] args) {
  
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
    
    Employee employee = new Employee();
    employee.setName("ruckmanm");
    employee.setSalary(10000);
    
    employeeRepository.saveAndFlush(employee);
  }
}
