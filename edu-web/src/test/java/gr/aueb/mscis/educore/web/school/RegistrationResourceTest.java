package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.web.BasicWebTest;
import gr.aueb.mscis.educore.web.binder.TestBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gr.aueb.mscis.educore.web.EducoreUri.*;

public class RegistrationResourceTest extends BasicWebTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RegistrationResource.class)
                .register(new TestBinder());
    }

    @Test
    public void registerOwner() {
        Owner entity = DataFactory.getValidOwner();
        Response response = target(REGISTRATIONS+OWNERS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Owner responseData = response.readEntity(Owner.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void registerGuardian() {
        Guardian entity = DataFactory.getValidGuardian();
        Response response = target(REGISTRATIONS+GUARDIANS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Guardian responseData = response.readEntity(Guardian.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }

    @Test
    public void registerTeacher() {
        Teacher entity = DataFactory.getValidTeacher();
        Response response = target(REGISTRATIONS+TEACHERS)
                .request()
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        Teacher responseData = response.readEntity(Teacher.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
    }
}