package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.service.school.impl.RegistrationServiceImpl;
import gr.aueb.mscis.educore.web.AbstractResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static gr.aueb.mscis.educore.web.EducoreUri.*;

@Path(REGISTRATIONS)
public class RegistrationResource extends AbstractResource {


    @Inject
    RegistrationServiceImpl registrationService;

    @RolesAllowed("OWNER")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(OWNERS)
    public Owner registerOwner(Owner owner){
        return registrationService.registerOwner(owner);
    }

    @RolesAllowed("OWNER")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(GUARDIANS)
    public Guardian registerGuardian(Guardian guardian){
        return registrationService.registerGuardian(guardian);
    }

    @RolesAllowed("OWNER")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(TEACHERS)
    public Teacher registerTeacher(Teacher teacher){
        return registrationService.registerTeacher(teacher);
    }
}
