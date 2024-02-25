package gr.aueb.mscis.educore.persistence.auth;

import gr.aueb.mscis.educore.model.auth.Session;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SessionDaoTest {

    SessionDao sessionDao;

    @BeforeEach
    public void setup(){
        sessionDao = DaoFactory.getSessionDao();
    }

    @Test
    public void findSessionByTokenTest(){
        Session session = DataFactory.getValidSession();
        Session createdSession = sessionDao.create(session);

        Assertions.assertNotNull(sessionDao.findByTokenKey(createdSession.getToken()));
    }

    @Test
    public void findUserByUserPassTest(){
        Assertions.assertNull(DaoFactory.getUserDao().findByUsernameAndPassword("a","a"));
    }
}
