package gr.aueb.mscis.educore.service.evaluation;

import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.service.factory.ServiceFactory;
import gr.aueb.mscis.educore.service.school.CourseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseServiceTest extends EducoreTest {
    CourseService courseService;

    @BeforeEach
    public void setup(){
        courseService = ServiceFactory.getCourseService();
    }

    @Test
    public void createCourseTest(){

        Course course = DataFactory.getValidCourse();
        Teacher teacher = DataFactory.getValidTeacher(true);
        course = courseService.saveCourse(teacher.getId(), course);
        Assertions.assertNotNull(course.getId());
        Assertions.assertEquals(course.getTeacher().getId(), teacher.getId());
    }

    @Test
    public void deleteCourseTest(){
        Course course = DataFactory.getValidCourse(true);
        Assertions.assertNotNull(course.getId());

        courseService.deleteCourse(course.getId());

        Assertions.assertNull(courseService.findCourseById(course.getId()));
    }

    @Test
    public void searchEvaluationTest(){
        Course course1 = DataFactory.getValidCourse(true);
        Course course2 = DataFactory.getValidCourse(true);
        Course course3 = DataFactory.getValidCourse(true);

        List<Course> courses = courseService.searchCourses(new SearchParameters());
        Assertions.assertEquals(3,courses.size());
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.addParameter("teacher.id", course1.getTeacher().getId());

        List<Course> results = courseService.searchCourses(searchParameters);

        Assertions.assertEquals(results.size(),1);
        Assertions.assertEquals(results.get(0).getTeacher().getId(), course1.getTeacher().getId());
    }
}
