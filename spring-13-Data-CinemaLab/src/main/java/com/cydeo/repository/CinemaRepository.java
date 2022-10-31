package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> getAllByName(String name);


    //Write a derived query to read sorted the top 3 cinemas that contains
    // a specific sponsored name

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);


    //Write a derived query to list all cinemas in a specific country

    List<Cinema> getAllByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema> getAllByNameOrSponsoredName(String pattern);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id



    @Query("Select e.name from Cinema e where e.id=?1")
    Optional<String> findCinemaById(@Param("id")Long id);


    // ------------------- Native QUERIES ------------------- //



    //Write a native query to read all cinemas by location country
    @Query(value="Select * from cinema c join location l " +
            "on l.id=c.location_id where l.country=?1",nativeQuery = true )
    List<Cinema> findCinemasByCountry(@Param("country")String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value="Select * from cinema where name ilike concat('%',?1,'%') " +
            "or sponsored_name ilike concat('%',?1,'%')",nativeQuery = true)
    List<Cinema> findCinemasByNameOrSponsoredNameLike(@Param("pattern") String pattern);




    //Write a native query to sort all cinemas by name
    @Query(value="Select * from cinema order by name",nativeQuery = true)
    List<Cinema> getCinemasSortedByName();


    //Write a native query to distinct all cinemas by sponsored name
    @Query(value="Select distinct sponsored_name from cinema",nativeQuery = true)
    List<String> distinctBySponsoredName();

}
