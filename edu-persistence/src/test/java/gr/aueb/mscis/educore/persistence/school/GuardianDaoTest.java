package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuardianDaoTest extends EducoreTest {
    GuardianDaoImpl guardianDao;

    @BeforeEach
    public void init(){
        guardianDao = DaoFactory.getGuardianDao();
    }

    @Test
    public void createGuardianSuccessTest(){
        Guardian guardian = DataFactory.getValidGuardian();
        Guardian createdGuardian = guardianDao.saveGuardian(guardian);
        Assertions.assertNotNull(createdGuardian.getId());
    }

    @Test
    public void createGuardianFailUserNullTest(){
        Guardian guardian = DataFactory.getValidGuardian();
        guardian.setUser(null);
        Assertions.assertThrows(ValidationException.class, ()->guardianDao.saveGuardian(guardian), ExceptionMessages.USER_IS_NULL);
    }

    @Test
    public void createGuardianFailValidationTest(){
        Guardian guardian = DataFactory.getValidGuardian();
        guardian.getUser().setUsername("");
        Assertions.assertThrows(ValidationException.class, ()->guardianDao.saveGuardian(guardian), ExceptionMessages.INVALID_DATA);
    }

}
