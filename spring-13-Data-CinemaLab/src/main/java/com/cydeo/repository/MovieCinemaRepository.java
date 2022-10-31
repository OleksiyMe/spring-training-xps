package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    Optional<MovieCinema> findById(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> getAllByDateTimeAfter(LocalDateTime date);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderBOrderByMoviePriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> getAllByMovieNameContaining(String pattern);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinemaLocationName(String name);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("Select x from MovieCinema x where x.dateTime>?1")
    List<MovieCinema> getAllMovieCinemaWithReleaseDateGreater(@Param("date") LocalDateTime date);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value="Select count(*) from mowie_cinema" +
            "where cinema_id=?1",nativeQuery = true)
    Integer countMovieCinemasById (@Param("id")Integer id);




    //Write a native query that returns all movie cinemas by location name
    @Query(value="Select * from mowie_cinema mc join cinema c " +
            "on c.id=mc.cinema_id join location l on l.id=c.location_id" +
            "where l.name=?1",nativeQuery = true)

    List<MovieCinema> retrieveAllByLocationName (@Param("name")String name);

}
