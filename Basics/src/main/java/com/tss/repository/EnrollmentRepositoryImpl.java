package com.tss.repository;

import com.tss.entity.Course;
import com.tss.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    private Connection connection;

    public EnrollmentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enrollStudent(Course course, Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO enrollment (course_id, student_id) VALUES (?, ?)"
            );
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setInt(2, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getEnrolledStudents(int id) {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM enrollment WHERE student_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Course> getEnrolledCourses(int id) {
        return List.of();
    }
}
