package sti.amir.domain;

import java.util.List;

public class Teacher {
    private final String GIVEN_NAME;
    private final String SURNAME;
    private final int PERSON_NMR;
    private final List<Course> COURSES;
    private final int HOURLY_SALARY;

    public Teacher(TeacherBuilder builder) {
        this.GIVEN_NAME = builder.GIVEN_NAME;
        this.SURNAME = builder.SURNAME;
        this.PERSON_NMR = builder.personNmr;
        this.COURSES = builder.courses;
        this.HOURLY_SALARY = builder.hourlySalary;
    }

    public String getGivenName() {return GIVEN_NAME;}

    public String getSurname() {
        return SURNAME;
    }

    public int getPersonNmr() {
        return PERSON_NMR;
    }

    public List<Course> getCourses() {return COURSES;}

    public int getHourlySalary() {
        return HOURLY_SALARY;
    }


    public static class TeacherBuilder {
        private final String GIVEN_NAME;
        private final String SURNAME;
        private int personNmr;
        private List<Course> courses;
        private int hourlySalary;

        public TeacherBuilder(String givenName, String surname) {
            this.GIVEN_NAME = givenName;
            this.SURNAME = surname;
        }

        public TeacherBuilder personNmr(int personNmr) {
            this.personNmr = personNmr;
            return this;
        }

        public TeacherBuilder courses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public TeacherBuilder hourlySalary(int hourlySalary) {
            this.hourlySalary = hourlySalary;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
