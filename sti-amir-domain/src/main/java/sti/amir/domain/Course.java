package sti.amir.domain;

import javafx.util.Builder;

public class Course {
    private final int YH_POINTS;
    private final Teacher TEACHER;
    private final int COURSE_CODE;
    private final int AMOUNT_OF_HOURS;


    public Course (CourseBuilder builder){
        this.YH_POINTS = builder.yhPoints;
        this.TEACHER = builder.TEACHER;
        this.COURSE_CODE = builder.courseCode;
        this.AMOUNT_OF_HOURS = builder.amountOfHours;
    }

    public int getYhPoints() {
        return YH_POINTS;
    }

    public Teacher getTeacher() {
        return TEACHER;
    }

    public int getCourseCode() {
        return COURSE_CODE;
    }

    public int getAmountOfHours() {
        return AMOUNT_OF_HOURS;
    }


    public static class CourseBuilder{
        private int yhPoints;
        private final Teacher TEACHER;
        private int courseCode;
        private int amountOfHours;


        public CourseBuilder(Teacher teacher){
            this.TEACHER = teacher;
        }

        public CourseBuilder withYhPoints(int yhPoints){
            this.yhPoints = yhPoints;
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
            return new Course(this);
        }
    }
}
