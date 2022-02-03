package sti.amir.ali.dao;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;

import java.sql.*;

public class AmirAliDaoImpl implements AmirAliDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmirAliDaoImpl.class);

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/stidb", "sti", "sti");
    }


    @Override
    public Student createStudent(String givenName, String surname, long personmr, String computer) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result;
        try {

            connection = getConnection();
            statement = connection.prepareStatement
                    ("INSERT INTO Student(given_name, surname, personnummer, computer) VALUES(?,?,?,?)");
            statement.setString(1, givenName);
            statement.setString(2, surname);
            statement.setLong(3, personmr);
            statement.setString(4, computer);
            result = statement.execute();
        } catch (SQLException sqlException) {
            LOGGER.error("Couldn't execute sql statement", sqlException);
        } finally {
            try {
                statement.close();
            } catch (Throwable ignore) {
            }
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
        }
        return Student.builder().withGivenName(givenName).withSurname(surname).withPersonNmr(personmr).withComputer(computer)
                .build();
    }

    @Override
    public void addCourse(Student student, Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result;
        try {

            connection = getConnection();
            statement = connection.prepareStatement
                    ("INSERT INTO Course(courseCode, name, teacher, amount_of_hours) VALUES(?,?,?,?)");
            statement.setInt(1, course.getCourseCode());
            statement.setString(2, course.getNAME());
            statement.setString(3, course.getTeacher().getSurname());
            statement.setInt(4, course.getAmountOfHours());
            result = statement.execute();
        } catch (SQLException sqlException) {
            LOGGER.error("Couldn't execute sql statement", sqlException);
        } finally {
            try {
                statement.close();
            } catch (Throwable ignore) {
            }
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
        }

        try {
            connection = getConnection();
            statement = connection.prepareStatement
                    ("INSERT INTO Student_Course(stud_personnummer, courseCode) VALUES(?,?)");
            statement.setLong(1, student.getPersonNmr());
            statement.setInt(2, course.getCourseCode());
            result = statement.execute();
        } catch (SQLException sqlException) {
            LOGGER.error("Couldn't execute sql statement", sqlException);
        } finally {
            try {
                statement.close();
            } catch (Throwable ignore) {
            }
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
        }

    }

    @Override
    public void removeCourse(Student student, int courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result;
        try {

            connection = getConnection();
            statement = connection.prepareStatement
                    ("DELETE FROM Student_Course WHERE stud_personnummer = ? AND courseCode = ?");
            statement.setLong(1,student.getPersonNmr());
            statement.setInt(2,courseCode);
                    result = statement.execute();
        } catch (SQLException sqlException) {
            LOGGER.error("Couldn't execute sql statement", sqlException);
        } finally {
            try {
                statement.close();
            } catch (Throwable ignore) {
            }
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

}
