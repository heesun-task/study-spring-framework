package com.hs.springboot.learnjpaandhibernate.course.jdbc;

import com.hs.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(1, 'Learn AWS', 'hs');
            """;

    // When we use ? in the query, we need to pass the values as arguments to the update method.
    private static String INSERT_QUERY2 =
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
                delete from course
                where id = ?
            """;

    public static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;

    public void insert(Course course) {
//        springJdbcTemplate.update(INSERT_QUERY);
        springJdbcTemplate.update(INSERT_QUERY2,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // Result Set -> Bean => Row Mapper =>
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}
