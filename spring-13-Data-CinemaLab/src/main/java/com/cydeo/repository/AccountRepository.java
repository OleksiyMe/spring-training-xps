package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> getAccountByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with
    // age lower than or equal to a specific value
    List<Account> getAccountByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> getAllByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts
    // where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("Select e from Account e")
    List<Account> getAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("Select e from Account e where e.role = 'ADMIN'")
    List<Account> getAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("Select e from Account e order by e.age")
    List<Account> getAllAccountsOrderByAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "Select * from account_details where age<?1", nativeQuery = true)
    List<Account> getAccontsWithAgeLowerThan(@Param("age") Integer age);  //u can use it
    // @Param all the time (For named pr positional parameters)

    //Write a native query to read all accounts that a specific value can be containable
    // in the name, address, country, state city
    @Query(value = "Select * from account_details a where name ilike concat('%',?1,'%')" +

            "or address  ilike concat('%',?1,'%')" +
            " or country  ilike concat('%',?1,'%')" +
            " or a.state  ilike concat('%',?1,'%')" +
            " or city ilike concat('%',?1,'%')",
            nativeQuery = true)
    List<Account> getAccontsBySearchPattern(@Param("pattern") String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "Select * from account_details where age>?1", nativeQuery = true)
    List<Account> getAccontsWithAgeGreaterThan(@Param("age")Integer age);

}
