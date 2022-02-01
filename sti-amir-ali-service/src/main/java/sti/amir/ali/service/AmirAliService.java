package sti.amir.ali.service;

import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;
import sti.amir.ali.domain.Teacher;

import java.util.List;

public interface AmirAliService {
    Student getStudent(int personNmr, List<Student> students);

    Student addStudent();

    void addCourse(Student student, Course course);

    void removeCourse(Student student, int courseCode);

    int calcSalary(Teacher teacher);

    int calcAverageSalary(List<Teacher> teachers);
}
