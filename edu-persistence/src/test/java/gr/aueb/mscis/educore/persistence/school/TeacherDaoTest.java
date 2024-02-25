package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TeacherDaoTest extends EducoreTest {
    TeacherDao teacherDao;
    @BeforeEach
    public void init(){
        teacherDao = DaoFactory.getTeacherDao();
    }

    @Test
    public void createTeacherSuccessTest(){
        Teacher teacher = DataFactory.getValidTeacher();
        Teacher createdTeacher = teacherDao.saveTeacher(teacher);
        Assertions.assertNotNull(createdTeacher.getId());
    }

    @Test
    public void createOwnerFailUserNullTest(){
        Teacher teacher = DataFactory.getValidTeacher();
        teacher.setUser(null);
        Assertions.assertThrows(ValidationException.class, ()->teacherDao.saveTeacher(teacher), ExceptionMessages.USER_IS_NULL);
    }

    @Test
    public void createGuardianFailValidationTest(){
        Teacher teacher = DataFactory.getValidTeacher();
        teacher.getUser().setNickname("");
        Assertions.assertThrows(ValidationException.class, ()->teacherDao.saveTeacher(teacher), ExceptionMessages.USER_IS_NULL);
    }

}
