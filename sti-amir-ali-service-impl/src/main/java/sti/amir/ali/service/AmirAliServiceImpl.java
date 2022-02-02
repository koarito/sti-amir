package sti.amir.ali.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;
import sti.amir.ali.domain.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmirAliServiceImpl implements AmirAliService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AmirAliServiceImpl.class);

    @Override
    public Student getStudent(int personNmr, List<Student> students) {

        Student student = null;
        for (Student x : students) {
            if (x.getPersonNmr() == personNmr)
                student = x;
        }
        try {
            System.out.printf("%s %s %s \n", student.getGivenName(), student.getSurname(), student.coursesToString());
        } catch (NullPointerException e) {
            LOGGER.error("Failed to find student with that personummer",e);
            return null;
        }
        LOGGER.trace("Student found");
        return student;
    }

    @Override
    public Student addStudent(String givenName, String surname, List<Course> courses, String computer, int personmr) {
        return Student.builder()
                .withGivenName(givenName)
                .withSurname(surname)
                .withCourses(courses)
                .withComputer(computer)
                .withPersonNmr(personmr)
                .build();
    }

    public void addCourse(Student student, Course course) {
        List<Course> courses = new ArrayList<>();
        if(student.getCourses() != null)
        courses = student.getCourses();
        courses.add(course);

        student.setCourses(courses);

    }
    @Override
    public void removeCourse(Student student, int courseCode) {
    List<Course> courses = student.getCourses();
    courses.removeIf(x -> x.getCourseCode() == courseCode);
    student.setCourses(courses);
    }

    @Override
    public int calcSalary(Teacher teacher) {
        int totalHours = 0;
        for(Course x : teacher.getCourses()){
            totalHours += x.getAmountOfHours();
        }
         return teacher.getHourlySalary() * totalHours;
    }

    @Override
    public int calcAverageSalary(List<Teacher> teachers) {
        int totalAmount = 0;
        for (Teacher x : teachers){
            totalAmount += calcSalary(x);
        }
        return totalAmount / teachers.size();
    }
}

