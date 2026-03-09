package com.tss.repository;

import com.tss.entity.Course;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    private Connection connection;

    public CourseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        return courses;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public void save(Course course) {

    }
}
