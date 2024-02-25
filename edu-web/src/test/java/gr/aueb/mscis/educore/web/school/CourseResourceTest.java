package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.web.BasicWebTest;
import gr.aueb.mscis.educore.web.binder.TestBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static gr.aueb.mscis.educore.web.EducoreUri.COURSES;

public class CourseResourceTest extends BasicWebTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CourseResource.class)
                .register(new TestBinder());
    }

    @Test
    public void saveCourse() {
        Course course = DataFactory.getValidCourse();

        Response response = target(COURSES)
                .request()
                .post(Entity.entity(course, MediaType.APPLICATION_JSON_TYPE));

        Course responseData = response.readEntity(Course.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void deleteCourse() {
        Course entity = DataFactory.getValidCourse(true);
        Assert.assertNotNull(entity.getId());
        target(COURSES+"/"+entity.getId())
                .request()
                .delete();

        List<Course> entities = target(COURSES)
                .request()
                .get(new GenericType<List<Course>>() {});

        Assert.assertEquals(0, entities.size());
    }

    @Test
    public void searchCourse() {
        DataFactory.getValidCourse(true);
        DataFactory.getValidCourse(true);
        DataFactory.getValidCourse(true);

        List<Course> entities = target(COURSES)
                .request()
                .get(new GenericType<List<Course>>() {});

        Assert.assertEquals(3, entities.size());
    }
}