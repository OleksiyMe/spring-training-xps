package com.cydeo;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------REGIONS-----------");

       // System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));

       // System.out.println("findByCountry:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContaining:" +
                regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegion:" +
                regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("findTop2ByCountry:" +
                regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" +
                regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("-----------DEPARTMENTS----------");
        System.out.println("findByDepartment:" +
                departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" +
                departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" +
                departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains:" +
                departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("-----------EMPLOYEES----------");
        //DisplayAllEmployeesWithEmailAddress
        System.out.println(employeeRepository.findByEmailContaining("woatesg6"));
        System.out.println(employeeRepository
                .findByFirstNameAndLastNameOrEmailContainsIgnoreCase("Charlie", "Yakubovics", "ffreanb5@ca.gov" ));

      //  System.out.println(employeeRepository.findByFirstNameNot("ozzy"));
        System.out.println("readByLastNameStartingWith Ang: ");
        System.out.println(employeeRepository.readByLastNameStartingWith("Ang"));
        System.out.println("Salary higher than 166000");
        System.out.println(employeeRepository.findBySalaryGreaterThan(166000));
        System.out.println("Salary less than 21000");
        System.out.println(employeeRepository.findBySalaryLessThan(21000));
        System.out.println("Hired between ");
        System.out.println(employeeRepository.findByHireDateBetween(
                LocalDate.of(2012,01,17),
                LocalDate.of(2012,01,31)
        ));
        System.out.println();
        System.out.println(employeeRepository.findBySalaryGreaterThanEqualOrderBySalary(166000));
        System.out.println(        );
        System.out.println(employeeRepository.findDistinctTop3BySalaryLessThan(23000));
        System.out.println("Email is null");
        System.out.println(employeeRepository.findTop4ByEmailIsNull());

        System.out.println("JPQL");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println(employeeRepository.retrieveEmployeeSalary());
        System.out.println("========COURSES==============");
        System.out.println();
    }
}
