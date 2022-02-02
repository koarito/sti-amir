package sti.amir.ali.dao;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AmirAliDaoImpl implements AmirAliDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(AmirAliDaoImpl.class);
    Connection connection = null;
    Statement statement = null;
    int result = 0;

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/stidb", "sti", "sti");
    }

    @Override
    public Student addStudent(String givenName, String surname, int personmr, String computer) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement
                    ("INSERT INTO Student(givenName, surname, personmr, computer) VALUES("
                            + givenName + "," + surname + "," + personmr + "," + computer +")");
            result = statement.executeUpdate("INSERT INTO Student(givenName, surname, personmr, computer) VALUES("
                    + givenName + "," + surname + "," + personmr + "," + computer +")");
        } catch (SQLException sqlException){
            LOGGER.error("Couldn't execute sql statement", sqlException);
        }
        return Student.builder().withGivenName(givenName).withSurname(surname).withPersonNmr(personmr).withComputer(computer)
                .build();
    }

    @Override
    public void addCourse(Student student, Course course) {

    }

    @Override
    public void removeCourse(Student student, int courseCode) {

    }

}
