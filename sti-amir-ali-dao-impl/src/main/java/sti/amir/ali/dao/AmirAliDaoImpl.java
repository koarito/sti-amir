package sti.amir.ali.dao;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sti.amir.ali.domain.Course;
import sti.amir.ali.domain.Student;

import java.sql.*;

public class AmirAliDaoImpl implements AmirAliDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(AmirAliDaoImpl.class);

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/stidb", "sti", "sti");
    }


    @Override
    public Student addStudent(String givenName, String surname, int personmr, String computer, int courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result;
        try {

            connection = getConnection();
            statement = connection.prepareStatement
                    ("INSERT INTO Student(given_name, surname, personnummer, computer) VALUES(?,?,?,?)");
            statement.setString(1,givenName);
            statement.setString(2,surname);
            statement.setInt(3,personmr);
            statement.setString(4, computer);
            result = statement.execute();
        } catch (SQLException sqlException){
            LOGGER.error("Couldn't execute sql statement", sqlException);
        } finally {
            try {
                statement.close();
            } catch (Throwable ignore){}
            try {
                connection.close();
            } catch (Throwable ignore){}
        }
        return Student.builder().withGivenName(givenName).withSurname(surname).withPersonNmr(personmr).withComputer(computer)
                .build();
    }

    @Override
    public void addCourse(Student student) {

    }

    @Override
    public void removeCourse(Student student, int courseCode) {

    }

}
