package com.hs.springboot.learnjpaandhibernate.course.jdbc;

import com.hs.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "hs"));
        repository.insert(new Course(2, "Learn Azure", "hs"));
        repository.insert(new Course(3, "Learn React", "hs"));
        repository.deleteById(3L);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(1));
    }
}
