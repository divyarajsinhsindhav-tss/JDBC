package com.tss.service;

import com.tss.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void addStudent(Student student);
}
