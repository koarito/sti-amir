package sti.amir.ali.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;
import sti.amir.ali.service.AmirAliService;

import java.util.Arrays;
import java.util.List;

public class TestService {
    ApplicationContext context = new ClassPathXmlApplicationContext("sti-amir-ali-service.xml");
    AmirAliService amirAliService = (AmirAliService) context.getBean("ServiceBean");

    @Test
    public void test() {
        Course course1 = Course.builder()
                .withName("Java")
                .withCourseCode(975)
                .build();

        Course course2 = Course.builder()
                .withName("Python")
                .build();
        List<Course> courses = Arrays.asList(course1, course2);
        Student student1 = Student.builder()
                .withPersonNmr(879)
                .withGivenName("Amir")
                .withSurname("Honein")
                .withCourses(courses)
                .build();
        Student student2 = Student.builder()
                .withPersonNmr(965)
                .withGivenName("Ali")
                .withSurname("Muhamad")
                .withCourses(courses)
                .build();
        Student student3 = Student.builder()
                .withPersonNmr(256)
                .withGivenName("Stof")
                .withSurname("Stofi")
                .build();

        List<Student> students = Arrays.asList(student1, student2, student3);
        amirAliService.addCourse(student3, course1);
        amirAliService.addCourse(student3, course2);
        amirAliService.removeCourse(student3, 975);

        Assert.assertEquals(student3.getCourses().get(0).getNAME(), "Python");
        Assert.assertEquals("Muhamad", amirAliService.getStudent(965, students).getSurname());
    }
}
