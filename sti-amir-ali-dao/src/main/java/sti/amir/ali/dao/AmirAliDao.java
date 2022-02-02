package sti.amir.ali.dao;

import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;

public interface AmirAliDao {

    Student addStudent(String givenName, String surname, int personmr, String computer);

    void addCourse(Student student, Course course);

    void removeCourse(Student student, int courseCode);

    Connection getConnection() throws SQLException;
}
