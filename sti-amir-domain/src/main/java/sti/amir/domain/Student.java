package sti.amir.domain;

import java.util.List;

public class Student {
    private final String GIVEN_NAME;
    private final String SURNAME;
    private final int PERSON_NMR;
    private final List<Course> COURSES;
    private final String COMPUTER;


    public Student(StudentBuilder builder){
        this.GIVEN_NAME = builder.GIVEN_NAME;
        this.SURNAME = builder.SURNAME;
        this.PERSON_NMR = builder.personNmr;
        this.COURSES = builder.courses;
        this.COMPUTER = builder.computer;
    }

    public String getGivenName() {
        return GIVEN_NAME;
    }

    public String getSurname() {
        return SURNAME;
    }

    public int getPersonNmr() {
        return PERSON_NMR;
    }

    public List<Course> getCourses() {
        return COURSES;
    }

    public String getComputer() {
        return COMPUTER;
    }

    @Override
    public String toString(){
        return GIVEN_NAME + " " + SURNAME;
    }

    public static class StudentBuilder{
        private final String GIVEN_NAME;
        private final String SURNAME;
        private int personNmr;
        private List<Course> courses;
        private String computer;

        public StudentBuilder(String givenName, String surname){
            this.GIVEN_NAME = givenName;
            this.SURNAME = surname;
        }

        public StudentBuilder withPersonNmr(int personNmr){
            this.personNmr = personNmr;
            return this;
        }

        public StudentBuilder withCourses(List<Course> courses){
            this.courses = courses;
            return this;
        }

        public StudentBuilder withComputer(String computer){
            this.computer = computer;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
