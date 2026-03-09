package com.tss.service;

import com.tss.entity.Course;
import com.tss.repository.CourseRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }
}
