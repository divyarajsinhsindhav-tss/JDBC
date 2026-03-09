package com.tss.service;

import com.tss.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
}
