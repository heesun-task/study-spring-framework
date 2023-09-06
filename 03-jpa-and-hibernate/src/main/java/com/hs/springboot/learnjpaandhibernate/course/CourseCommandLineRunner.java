package com.hs.springboot.learnjpaandhibernate.course;

import com.hs.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.hs.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.hs.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;
//
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "hs"));
        repository.save(new Course(2, "Learn Azure", "mama"));
        repository.save(new Course(3, "Learn React", "hs"));
        repository.deleteById(3L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(1L));

        System.out.println("---more methods---");
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("mama"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Learn AWS"));
        System.out.println(repository.findByName(""));
    }
}
