package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //Find all couses by category


    List<Course> findByCategory(String category);

    //Fing all courses by category and order the entities by name

    List<Course> findByCategoryOrderByName(String category);
    //Check if a course with the supply name exists (boolean)

    boolean existsByCategory(String category);

    //count

    Integer countByCategory(String category);

//find all courses starting with
    List<Course> findAllByNameStartingWith(String string);

    //find all and return stream
    Stream<Course> streamAllByCategory(String category);

//


  @Query("Select x From Course x Where x.category=?1")
    List<Course> abc(String category);


  @Query("Select c from Course c where c.category= :category AND c.rating > :rating")
  List<Course>  retrieveAllCourseByCategoryAndRatingGreaterThan(@Param("category")
         String category   , @Param("rating") int rating) ;

















}
