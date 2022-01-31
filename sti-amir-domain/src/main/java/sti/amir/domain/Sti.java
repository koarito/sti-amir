package sti.amir.domain;

import java.util.List;

public class Sti {
    private final List<Student> STUDENTS;

    public Sti(StiBuilder builder){
        this.STUDENTS = builder.STUDENTS;
    }

    public List<Student> getStudents() {
        return STUDENTS;
    }

    public static class StiBuilder{
        private final List<Student> STUDENTS;

        public StiBuilder (List<Student> students){
            this.STUDENTS = students;
        }
        public Sti build(){
            return new Sti(this);
        }
    }
}
