package gr.aueb.mscis.educore.persistence.test;

import gr.aueb.mscis.educore.persistence.test.util.DBHelper;
import org.junit.jupiter.api.AfterEach;

import java.sql.SQLException;

public abstract class EducoreTest {

    @AfterEach
    public void truncateAll(){
        try {
            DBHelper.truncateAll();
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
