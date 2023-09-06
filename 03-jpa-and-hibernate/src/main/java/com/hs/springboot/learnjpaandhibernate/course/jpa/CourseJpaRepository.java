package com.hs.springboot.learnjpaandhibernate.course.jpa;

import com.hs.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {

//    @Autowired
    // We don't need to autowire the EntityManager as it is already available in the Spring Context.
    // We can directly use the @PersistenceContext annotation to inject the EntityManager.
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
}
