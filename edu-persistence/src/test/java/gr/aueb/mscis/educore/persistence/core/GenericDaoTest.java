package gr.aueb.mscis.educore.persistence.core;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.core.CoreEntity;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.persistence.GenericDao;
import gr.aueb.mscis.educore.persistence.auth.impl.SessionDaoImpl;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.evaluation.impl.EvaluationDaoImpl;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.school.impl.CourseDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.EnrolmentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.OwnerDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericDaoTest {

    @Test
    public void genericEvaluationDaoImplTest() {
        genericCRUDTest(EvaluationDaoImpl.class);
    }

    @Test
    public void genericCourseDaoImplTest() {
        //Check search with name
        SearchParameters params = new SearchParameters();
        params.addParameter("id","-1");
        params.addParameter("name","a");
        List<Course> allSearch = DaoFactory.getCourseDao().search(params);
        Assertions.assertNotNull(allSearch);

        genericCRUDTest(CourseDaoImpl.class);
    }

    @Test
    public void genericEnrolmentDaoImplTest() {
        genericCRUDTest(EnrolmentDaoImpl.class);
    }

    @Test
    public void genericGuardianDaoImplTest() {
        genericCRUDTest(GuardianDaoImpl.class);
    }

    @Test
    public void genericOwnerDaoImplTest() {
        genericCRUDTest(OwnerDaoImpl.class);
    }

    @Test
    public void genericTeacherDaoImplTest() {
        genericCRUDTest(TeacherDaoImpl.class);
    }

    @Test
    public void genericSessionDaoImplTest() {
        genericCRUDTest(SessionDaoImpl.class);
    }

    @Test
    public void genericUserDaoImplTest() {
        genericCRUDTest(UserDaoImpl.class);
    }

    public void genericCRUDTest(Class<? extends GenericDao> cls) {
        GenericDao dao = instantiate(cls);

        //Create
        CoreEntity entity = dao.create(DataFactory.getProperValidEntity(dao));
        Assertions.assertNotNull(entity.getId());

        //Read
        CoreEntity entityFromDB = dao.findOne(entity.getId());
        Assertions.assertNotNull(entityFromDB);

        //Update
        Assertions.assertDoesNotThrow(() -> dao.update(entity));

        //Delete
        dao.delete(entity);

        //ensure entity is deleted
        Assertions.assertEquals(null, dao.findOne(entity.getId()));

        //Create one more time
        CoreEntity newEntity = dao.create(DataFactory.getProperValidEntity(dao));
        Assertions.assertNotNull(newEntity.getId());

        //Check find all
        List<CoreEntity> all = dao.findAll();
        Assertions.assertNotNull(all);

        //Check search
        SearchParameters params = new SearchParameters();
        params.addParameter("id","-1");
        List<CoreEntity> allSearch = dao.search(params);
        Assertions.assertNotNull(allSearch);

        //Delete by id
        dao.deleteById(newEntity.getId());

        //ensure entity is deleted
        Assertions.assertEquals(null, dao.findOne(newEntity.getId()));

    }

    private GenericDao instantiate(Class<? extends GenericDao> cls) {
        try {
            return cls.newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
