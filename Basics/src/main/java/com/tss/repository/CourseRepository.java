package com.tss.repository;

import com.tss.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();
    Course findById(int id);
    void save(Course course);
}
