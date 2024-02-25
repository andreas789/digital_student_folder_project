package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.model.school.Teacher;
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

import static gr.aueb.mscis.educore.web.EducoreUri.GUARDIANS;
import static gr.aueb.mscis.educore.web.EducoreUri.OWNERS;
import static gr.aueb.mscis.educore.web.EducoreUri.SCHOOL_MANAGEMENT;
import static gr.aueb.mscis.educore.web.EducoreUri.STUDENTS;
import static gr.aueb.mscis.educore.web.EducoreUri.TEACHERS;

public class SchoolManagementResourceTest extends BasicWebTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(SchoolManagementResource.class)
                .register(new TestBinder());
    }

    @Test
    public void saveOwner() {
        Owner entity = DataFactory.getValidOwner();
        Response response = target(SCHOOL_MANAGEMENT+OWNERS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Owner responseData = response.readEntity(Owner.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void deleteOwner() {
        DataFactory.getValidOwner(true);
        Owner entity = DataFactory.getValidOwner(true);
        Assert.assertNotNull(entity.getId());
        target(SCHOOL_MANAGEMENT+OWNERS+"/"+entity.getId())
                .request()
                .delete();

        List<Owner> entities = target(SCHOOL_MANAGEMENT+OWNERS)
                .request()
                .get(new GenericType<List<Owner>>() {});

        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void searchOwner() {
        Owner entity1 = DataFactory.getValidOwner(true);
        DataFactory.getValidOwner(true);
        DataFactory.getValidOwner(true);

        List<Owner> entities = target(SCHOOL_MANAGEMENT+OWNERS)
                .request()
                .get(new GenericType<List<Owner>>() {});
        Assert.assertEquals(3, entities.size());

        entities = target(SCHOOL_MANAGEMENT+OWNERS)
                .queryParam("id",entity1.getId())
                .queryParam("name",entity1.getName())
                .request()
                .get(new GenericType<List<Owner>>() {});
        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void saveTeacher() {
        Teacher entity = DataFactory.getValidTeacher();
        Response response = target(SCHOOL_MANAGEMENT+TEACHERS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Teacher responseData = response.readEntity(Teacher.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void deleteTeacher() {
        DataFactory.getValidTeacher(true);
        Teacher entity = DataFactory.getValidTeacher(true);
        Assert.assertNotNull(entity.getId());
        target(SCHOOL_MANAGEMENT+TEACHERS+"/"+entity.getId())
                .request()
                .delete();

        List<Teacher> entities = target(SCHOOL_MANAGEMENT+TEACHERS)
                .request()
                .get(new GenericType<List<Teacher>>() {});

        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void searchTeacher() {
        Teacher entity1 = DataFactory.getValidTeacher(true);
        DataFactory.getValidTeacher(true);
        DataFactory.getValidTeacher(true);

        List<Teacher> entities = target(SCHOOL_MANAGEMENT+TEACHERS)
                .request()
                .get(new GenericType<List<Teacher>>() {});
        Assert.assertEquals(3, entities.size());

        entities = target(SCHOOL_MANAGEMENT+TEACHERS)
                .queryParam("id",entity1.getId())
                .queryParam("name",entity1.getName())
                .request()
                .get(new GenericType<List<Teacher>>() {});
        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void saveGuardian() {
        Guardian entity = DataFactory.getValidGuardian();
        Response response = target(SCHOOL_MANAGEMENT+GUARDIANS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Guardian responseData = response.readEntity(Guardian.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void deleteGuardian() {
        DataFactory.getValidGuardian(true);
        Guardian entity = DataFactory.getValidGuardian(true);
        Assert.assertNotNull(entity.getId());
        target(SCHOOL_MANAGEMENT+GUARDIANS+"/"+entity.getId())
                .request()
                .delete();

        List<Guardian> entities = target(SCHOOL_MANAGEMENT+GUARDIANS)
                .request()
                .get(new GenericType<List<Guardian>>() {});

        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void searchGuardians() {
        Guardian entity1 = DataFactory.getValidGuardian(true);
        DataFactory.getValidGuardian(true);
        DataFactory.getValidGuardian(true);

        List<Guardian> entities = target(SCHOOL_MANAGEMENT+GUARDIANS)
                .request()
                .get(new GenericType<List<Guardian>>() {});
        Assert.assertEquals(3, entities.size());

        entities = target(SCHOOL_MANAGEMENT+GUARDIANS)
                .queryParam("id",entity1.getId())
                .queryParam("name",entity1.getName())
                .request()
                .get(new GenericType<List<Guardian>>() {});
        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void saveStudent() {
        Student entity = DataFactory.getValidStudent();
        Response response = target(SCHOOL_MANAGEMENT+STUDENTS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Student responseData = response.readEntity(Student.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void deleteStudent() {
        DataFactory.getValidStudent(true);
        Student entity = DataFactory.getValidStudent(true);
        Assert.assertNotNull(entity.getId());
        target(SCHOOL_MANAGEMENT+STUDENTS+"/"+entity.getId())
                .request()
                .delete();

        List<Student> entities = target(SCHOOL_MANAGEMENT+STUDENTS)
                .request()
                .get(new GenericType<List<Student>>() {});

        Assert.assertEquals(1, entities.size());
    }

    @Test
    public void searchStudents() {
        Student entity1 = DataFactory.getValidStudent(true);
        DataFactory.getValidStudent(true);
        DataFactory.getValidStudent(true);

        List<Student> entities = target(SCHOOL_MANAGEMENT+STUDENTS)
                .request()
                .get(new GenericType<List<Student>>() {});
        Assert.assertEquals(3, entities.size());

        entities = target(SCHOOL_MANAGEMENT+STUDENTS)
                .queryParam("id",entity1.getId())
                .queryParam("name",entity1.getName())
                .request()
                .get(new GenericType<List<Student>>() {});
        Assert.assertEquals(1, entities.size());
    }
}