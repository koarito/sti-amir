package sti.amir.ali.service;

import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;
import sti.amir.ali.domain.Teacher;

import java.util.List;

public interface AmirAliService {
    Student getStudent(int personNmr, List<Student> students);

    Student addStudent();

    List<Course> addCourse(List<Course> courses, Course course);

    List<Course> removeCourse(List<Course> courses, int courseCode);

    int calcSalary(Teacher teacher);

    int calcAverageSalary(List<Teacher> teachers);
}
