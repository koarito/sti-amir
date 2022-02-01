package sti.amir.ali.service;

import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;
import sti.amir.ali.domain.Teacher;

import java.util.List;

public class AmirAliServiceImpl implements AmirAliService{
    @Override
    public Student getStudent(int personNmr, List<Student> students) {

        Student student = null;
        for(Student x : students){
            if(x.getPersonNmr() == personNmr)
                student = x;
        }

        System.out.printf("%s %s %s \n", student.getGivenName(), student.getSurname(), student.coursesToString());
        return student;
    }

    @Override
    public Student addStudent() {
        return null;
    }

    @Override
    public List<Course> addCourse() {
        return null;
    }

    @Override
    public List<Course> removeCourse() {
        return null;
    }

    @Override
    public int calcSalary(Teacher teacher) {
        return 0;
    }

    @Override
    public int calcAverageSalary(List<Teacher> teachers) {
        return 0;
    }
}
