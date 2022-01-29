package sti.amir.domain;

import java.util.List;

public class Student {
    private String givenName;
    private String surname;
    private int personNmr;
    private List<Course> courses;
    private String computer;

    public Student(String givenName, String surname, int personNmr, List<Course> courses, String computer) {
        this.givenName = givenName;
        this.surname = surname;
        this.personNmr = personNmr;
        this.courses = courses;
        this.computer = computer;
    }

    public Student(StudentBuilder builder){
        this.givenName = builder.givenName;
        this.surname = builder.surname;
        this.personNmr = builder.personNmr;
        this.courses = builder.courses;
        this.computer = builder.computer;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPersonNmr() {
        return personNmr;
    }

    public void setPersonNmr(int personNmr) {
        this.personNmr = personNmr;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    @Override
    public String toString(){
        return givenName + " " + surname;
    }

    public static StudentBuilder builder(){return new StudentBuilder();}

    public static class StudentBuilder{
        private String givenName;
        private String surname;
        private int personNmr;
        private List<Course> courses;
        private String computer;

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withGivenName(String givenName){
            this.givenName = givenName;
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
            return new Student(this.givenName, this.surname, this.personNmr, this.courses, this.computer);
        }
    }
}
