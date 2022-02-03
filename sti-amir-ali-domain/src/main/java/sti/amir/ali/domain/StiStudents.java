package sti.amir.ali.domain;

import java.util.List;

public class StiStudents {
    private List<Student> students;

    private StiStudents(StiStudentBuilder builder){
        this.students = builder.students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public static StiStudentBuilder builder(){return new StiStudentBuilder();}


    public static class StiStudentBuilder{
        private List<Student> students;

        public StiStudentBuilder(){}

        public StiStudentBuilder withStudents(List<Student> students){
            this.students = students;
            return this;
        }
        public StiStudents build(){
            return new StiStudents(this);
        }
    }
}
