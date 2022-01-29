package sti.amir.domain;

import javafx.util.Builder;

public class Course {
    private int yhPoints;
    private Teacher teacher;
    private int courseCode;
    private int amountOfHours;

    public Course(int yhPoints, Teacher teacher, int courseCode, int amountOfHours) {
        this.yhPoints = yhPoints;
        this.teacher = teacher;
        this.courseCode = courseCode;
        this.amountOfHours = amountOfHours;
    }

    public Course (CourseBuilder builder){
        this.yhPoints = builder.yhPoints;
        this.teacher = builder.teacher;
        this.courseCode = builder.courseCode;
        this.amountOfHours = builder.amountOfHours;
    }

    public int getYhPoints() {
        return yhPoints;
    }

    public void setYh_points(int yhPoints) {
        this.yhPoints = yhPoints;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(int amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

    public CourseBuilder build(){
        return new CourseBuilder();
    }

    public static class CourseBuilder{
        private int yhPoints;
        private Teacher teacher;
        private int courseCode;
        private int amountOfHours;

        public CourseBuilder withYhPoints(int yhPoints){
            this.yhPoints = yhPoints;
            return this;
        }

        public CourseBuilder withTeacher(Teacher teacher){
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder withCourseCode(int courseCode){
            this.courseCode = courseCode;
            return this;
        }

        public CourseBuilder withAmountOFHours(int amountOfHours){
            this.amountOfHours = amountOfHours;
            return this;
        }

        public Course build(){
            return new Course(this.yhPoints, this.teacher, this.courseCode, this.amountOfHours);
        }
    }
}
