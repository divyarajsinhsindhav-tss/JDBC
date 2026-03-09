package com.tss.service;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.util.List;

public interface EnrollementService {
    void enrollStudent(Course course, Student student);
    List<String> getEnrolledStudents(int id);
}
