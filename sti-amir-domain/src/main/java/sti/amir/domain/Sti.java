package sti.amir.domain;

import java.util.List;

public class Sti {
    private List<Student> students;

    public Sti(List<Student> students) {
        this.students = students;
    }
    public Sti(StiBuilder builder){
        this.students = builder.students;
    }
    public static StiBuilder stiBuilder(){return new StiBuilder();}

    public static class StiBuilder{
        private List<Student> students;

        public StiBuilder withStudents(List<Student> students){
            this.students = students;
            return this;
        }
        public Sti build(){
            return new Sti(students);
        }
    }
}
