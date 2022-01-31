package sti.amir.ali.domain;

public class Course {
    private final int YH_POINTS;
    private final Teacher TEACHER;
    private final int COURSE_CODE;
    private final int AMOUNT_OF_HOURS;


    private Course(CourseBuilder builder) {
        this.YH_POINTS = builder.yhPoints;
        this.TEACHER = builder.teacher;
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

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    public static class CourseBuilder {
        private int yhPoints;
        private Teacher teacher;
        private int courseCode;
        private int amountOfHours;


        public CourseBuilder() {
        }

        public CourseBuilder withTeacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder withYhPoints(int yhPoints) {
            this.yhPoints = yhPoints;
            return this;
        }

        public CourseBuilder withCourseCode(int courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseBuilder withAmountOFHours(int amountOfHours) {
            this.amountOfHours = amountOfHours;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
