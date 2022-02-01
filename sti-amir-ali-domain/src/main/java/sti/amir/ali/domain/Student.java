package sti.amir.ali.domain;

import java.util.List;

public class Student {
    private final String GIVEN_NAME;
    private final String SURNAME;
    private final int PERSON_NMR;
    private List<Course> courses;
    private String computer;


    private Student(StudentBuilder builder){
        this.GIVEN_NAME = builder.givenName;
        this.SURNAME = builder.surname;
        this.PERSON_NMR = builder.personNmr;
        this.courses = builder.courses;
        this.computer = builder.computer;
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
        return courses;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public String coursesToString(){
        String string = "";

        if(courses != null){
        for (Course x : courses)
            string += x.getNAME() + " ";
        return string;}

        return null;
    }

    @Override
    public String toString(){
        return GIVEN_NAME + " " + SURNAME;
    }

    public static class StudentBuilder{

        private String givenName;
        private String surname;
        private int personNmr;
        private List<Course> courses;
        private String computer;

        public StudentBuilder(){}

        public StudentBuilder withGivenName(String givenName){
            this.givenName = givenName;
            return this;
        }

        public StudentBuilder withSurname(String surname){
            this.surname = surname;
            return this;
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
