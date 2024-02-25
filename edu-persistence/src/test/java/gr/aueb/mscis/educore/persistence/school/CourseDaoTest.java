package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseDaoTest extends EducoreTest {

    CourseDao courseDao;

    @BeforeEach
    public void setup(){
        courseDao = DaoFactory.getCourseDao();
    }

    @Test
    public void createCourseSuccessTest(){
        Course course = DataFactory.getValidCourse();
        Course createdCourse = courseDao.saveCourse(course);
        Assertions.assertNotNull(createdCourse.getId());
    }

    @Test
    public void createCourseFailTest(){
        Course course = DataFactory.getValidCourse();
        course.setCode(null);
        Assertions.assertThrows(ValidationException.class,()->courseDao.saveCourse(course), ExceptionMessages.INVALID_DATA);
    }
}
