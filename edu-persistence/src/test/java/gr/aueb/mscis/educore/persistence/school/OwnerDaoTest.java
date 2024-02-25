package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OwnerDaoTest extends EducoreTest {
    OwnerDao ownerDao;
    @BeforeEach
    public void init(){
       ownerDao = DaoFactory.getOwnerDao();
    }

    @Test
    public void createOwnerSuccessTest(){
        Owner owner = DataFactory.getValidOwner();
        Owner createdOwner = ownerDao.saveOwner(owner);
        Assertions.assertNotNull(createdOwner.getId());
    }

    @Test
    public void createOwnerFailUserNullTest(){
        Owner owner = DataFactory.getValidOwner();
        owner.setUser(null);
        Assertions.assertThrows(ValidationException.class, ()->ownerDao.saveOwner(owner), ExceptionMessages.USER_IS_NULL);
    }

    @Test
    public void createGuardianFailValidationTest(){
        Owner owner = DataFactory.getValidOwner();
        owner.getUser().setPassword("");
        Assertions.assertThrows(ValidationException.class, ()->ownerDao.saveOwner(owner), ExceptionMessages.USER_IS_NULL);
    }
}
