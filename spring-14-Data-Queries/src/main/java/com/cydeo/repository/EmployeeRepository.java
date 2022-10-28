package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    //DisplayAllEmployeesWithEmailAddress

    List<Employee> findByEmailContaining(String email);

    List<Employee> findByFirstNameAndLastNameOrEmailContainsIgnoreCase(String first, String last, String email);

    List<Employee> findByFirstNameNot(String name);

    List<Employee> readByLastNameStartingWith(String prefix);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate date1, LocalDate date2);

    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    List<Employee> findTop4ByEmailIsNull();
}
