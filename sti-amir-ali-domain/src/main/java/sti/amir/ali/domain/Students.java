package sti.amir.ali.domain;

import java.util.List;

public class Students {
    private final List<Student> students;

    private Students(StiBuilder builder){
        this.students = builder.students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public static Course.CourseBuilder builder(){return new Course.CourseBuilder();}

    public static class StiBuilder{
        private List<Student> students;

        public StiBuilder (List<Student> students){
            this.students = students;
        }

        public StiBuilder withStudents(List<Student> students){
            this.students = students;
            return this;
        }
        public Students build(){
            return new Students(this);
        }
    }
}
