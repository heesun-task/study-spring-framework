package com.hs.springboot.learnjpaandhibernate.course.springdatajpa;

import com.hs.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // Can add custom methods here.
    // Spring Data JPA will automatically implement the methods based on the method name.
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
