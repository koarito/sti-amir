package sti.amir.ali.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.amir.ali.dao.AmirAliDao;
import sti.amir.ali.domain.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDao {
    ApplicationContext context = new ClassPathXmlApplicationContext("sti-amir-ali-dao.xml");
    AmirAliDao amirAliDao = (AmirAliDao) context.getBean("DaoBean");

    @Test
    public void testGetConnection() throws SQLException {
        Connection connection = amirAliDao.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void testAddStudent(){
        Student student = amirAliDao.addStudent("Ali","Honein", 878, "Mac");
        Assert.assertEquals(student.getSurname(), "Honein");
    }
}
