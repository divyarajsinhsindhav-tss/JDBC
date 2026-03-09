package com.tss.repository;

import com.tss.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private Connection connection;

    public StudentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("studentId"),
                        resultSet.getInt("rollNumber"),
                        resultSet.getInt("age"),
                        resultSet.getString("name")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public void addStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Students (rollNumber, age, name) VALUES (?, ?, ?)"
            );
            statement.setInt(1, student.getRollNumber());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getName());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) {
        try {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Students WHERE studentId = ?"
                );
                ResultSet resultSet = statement.executeQuery();
                return new Student(resultSet.getInt("studentId"), resultSet.getInt("rollNumber"), resultSet.getInt("age"), resultSet.getString("name"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
