package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Enrolment;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnrolmentDaoTest extends EducoreTest {

    EnrolmentDao enrolmentDao;

    @BeforeEach
    public void setup(){
        enrolmentDao = DaoFactory.getEnrolmentDao();
    }

    @Test
    public void enrollSuccessTest(){
        Course course = DataFactory.getValidCourse(true);
        Student student = DataFactory.getValidStudent(true);
        Enrolment createdEnrolment = enrolmentDao.enroll(student, course);
        Assertions.assertNotNull(createdEnrolment.getId());
    }

    @Test
    public void enrollFailMaxStudentsTest(){
        Course course = DataFactory.getValidCourse(true);
        Student student = DataFactory.getValidStudent(true);
        course.setMaxParticipants(0);
        Assertions.assertThrows(ValidationException.class, ()->enrolmentDao.enroll(student, course), ExceptionMessages.MAX_PARTICIPANTS_REACHED);
    }

    @Test
    public void enrollFailAlreadyEnrolledTest(){
        Course course = DataFactory.getValidCourse(true);
        Student student = DataFactory.getValidStudent(true);
        //enroll the student to that course
        enrolmentDao.enroll(student, course);

        //and do that again
        Assertions.assertThrows(ValidationException.class, ()->enrolmentDao.enroll(student, course), ExceptionMessages.ENROLMENT_EXISTS);
    }
}
