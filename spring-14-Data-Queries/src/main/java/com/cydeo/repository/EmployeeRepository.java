package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("Select e From Employee e Where e.email='cyakubovicsq0@51.la'")
    Employee retrieveEmployeeDetail();

    @Query("Select e.salary from Employee e Where e.email='cyakubovicsq0@51.la'")
    Integer retrieveEmployeeSalary();
//
//Not equal

    @Query("Select e from Employee e where e.salary<>?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / StartsWith / EndsWith
    @Query("Select e from Employee e where e.firstName like ?1 ")
    List<Employee> retrieveEmpFirstNameLike(String pattern);

    //Less than
    @Query("Select e.firstName from Employee e where e.salary<?1")
    List<String> retrieveEmpSalaryLessThan(int salary);

    @Query("Select e from Employee e where e.salary>?1")
    List<Employee> retrieveEmpSalaryGreaterThan(int salary);


    //between
    @Query("Select e from Employee e where e.salary between ?1 and ?2")
    List<Integer> salariesBetween(int a, int b);

    //before
    @Query("Select e from Employee e where e.hireDate> ?1")
    List<Employee> hiredBefore(LocalDate date);

    //null
    @Query("Select e from Employee e where e.email is null ")
    List<Employee> employeeEmailIsNull();

    //sorting in Asc order
    @Query("Select e from Employee e order by e.salary asc ")
    List<Employee>  employeeSalarySortedAsc();
    //sorting in Desc order
    @Query("Select e from Employee e order by e.salary desc ")
    List<Employee>  employeeSalarySortedDesc();

    //Native query

    @Query(value="Select * from employees where salary =?1", nativeQuery = true)
    List<Employee> retrieveEmplDetailBySalary(int salary);

    //Named Parameter
    @Query("Select e from Employee e where e.salary= :salary")
    List<Employee> retrieveEmpSalary(@Param("salary") int Salary);

    //














}
