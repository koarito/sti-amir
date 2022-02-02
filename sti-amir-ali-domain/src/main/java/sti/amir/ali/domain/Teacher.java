package sti.amir.ali.domain;

import java.util.List;

public class Teacher {
    private final String GIVEN_NAME;
    private final String SURNAME;
    private final int PERSON_NMR;
    private List<Course> courses;
    private int hourlySalary;

    public Teacher(TeacherBuilder builder) {
        this.GIVEN_NAME = builder.givenName;
        this.SURNAME = builder.surname;
        this.PERSON_NMR = builder.personNmr;
        this.courses = builder.courses;
        this.hourlySalary = builder.hourlySalary;
    }

    public String getGivenName() {return GIVEN_NAME;}

    public String getSurname() {
        return SURNAME;
    }

    public int getPersonNmr() {
        return PERSON_NMR;
    }

    public List<Course> getCourses() {return courses;}

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public static TeacherBuilder builder(){return new TeacherBuilder();}

    public static class TeacherBuilder {
        private String givenName;
        private String surname;
        private int personNmr;
        private List<Course> courses;
        private int hourlySalary;

        public TeacherBuilder(){}

        public TeacherBuilder withGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public TeacherBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public TeacherBuilder withPersonNmr(int personNmr) {
            this.personNmr = personNmr;
            return this;
        }

        public TeacherBuilder withCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public TeacherBuilder withHourlySalary(int hourlySalary) {
            this.hourlySalary = hourlySalary;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
