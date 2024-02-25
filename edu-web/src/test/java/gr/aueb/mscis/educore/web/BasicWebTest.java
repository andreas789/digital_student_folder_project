package gr.aueb.mscis.educore.web;

import gr.aueb.mscis.educore.persistence.test.util.DBHelper;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;

import java.sql.SQLException;

public abstract class BasicWebTest extends JerseyTest {

    @After
    public void truncateAll(){
        try {
            DBHelper.truncateAll();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
