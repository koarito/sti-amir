package sti.amir.ali.endpoint;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.StiStudents;
import sti.amir.ali.domain.Student;
import sti.amir.ali.domain.Teacher;
import sti.amir.ali.service.AmirAliService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/service")
public class EndpointService {
    ApplicationContext context = new ClassPathXmlApplicationContext("sti-amir-ali-service.xml");
    AmirAliService amirAliService = (AmirAliService) context.getBean("ServiceBean");

    private StiStudents stiStudents;
    public EndpointService() {

        Student student1 = Student.builder()
                .withPersonNmr(200006215971L)
                .withGivenName("Amir")
                .withSurname("Honein")
                .withComputer("Windows")
                .build();
        Student student2 = Student.builder()
                .withPersonNmr(196509185469L)
                .withGivenName("Ali")
                .withSurname("Muhamad")
                .withComputer("Windows")
                .build();
        Student student3 = Student.builder()
                .withPersonNmr(197504056321L)
                .withGivenName("Stof")
                .withSurname("Stofi")
                .withComputer("Mac")
                .build();

        List<Student> students = Arrays.asList(student1, student2, student3);
        Teacher teacher1 = Teacher.builder()
                .withGivenName("Özgur")
                .withSurname("Kibar")
                .withPersonNmr(198903128596L)
                .build();

        Course course1 = Course.builder()
                .withName("Java")
                .withTeacher(teacher1)
                .withCourseCode(975)
                .build();

        Course course2 = Course.builder()
                .withName("Python")
                .withTeacher(teacher1)
                .build();
        List<Course> courses = Arrays.asList(course1, course2);

         stiStudents = StiStudents.builder()
                .withStudents(students)
                        .build();
        teacher1.setCourses(courses);
    }

    @GetMapping("/getstudent")
    @ApiOperation(value = "Returns student from list with personnummer as input")
    public Student getStudent(@RequestParam int personmr) {
        return amirAliService.getStudent(personmr,stiStudents.getStudents());
    }

    @GetMapping("/createnewstudent")
    @ApiOperation(value = "Creates a new student")
    public Student createStudent(@RequestParam String givenName, String surname, List<Course> courses,
                                 String computer, long personmr){
        return amirAliService.createStudent(givenName, surname, courses, computer, personmr);
    }

    @PostMapping("/addcourse")
    @ApiOperation(value = "Adds course to a student")
    public void addCourse(@RequestParam Student student, Course course){
        amirAliService.addCourse(student, course);
    }

    @PostMapping("/removecourse")
    @ApiOperation(value = "Removes course from a student")
    public void removeCourse(@RequestParam Student student, int courseCod){
        amirAliService.removeCourse(student, courseCod);
    }

    @GetMapping("/gettechersalary")
    @ApiOperation(value = "Returns teachers salary")
    public int calcSalary(@RequestParam Teacher teacher){
        return amirAliService.calcSalary(teacher);
    }

    @GetMapping("/getaveragesalary")
    @ApiOperation(value = "Returns average salary of teachers in list")
    public int calcAverageSalary(@RequestParam List<Teacher> teachers){
        return amirAliService.calcAverageSalary(teachers);
    }
}
