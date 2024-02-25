package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.dto.search.PersonSearchParameters;
import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.service.school.impl.SchoolManagementServiceImpl;
import gr.aueb.mscis.educore.web.AbstractResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static gr.aueb.mscis.educore.web.EducoreUri.*;


@Path(SCHOOL_MANAGEMENT)
public class SchoolManagementResource extends AbstractResource {

    @Inject
    SchoolManagementServiceImpl schoolManagementService;

    @RolesAllowed("OWNER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path(OWNERS)
    public Owner saveOwner(Owner owner){
        return schoolManagementService.saveOwner(owner);
    }

    @RolesAllowed("OWNER")
    @DELETE
    @Path(OWNERS+"/{id}")
    public void deleteOwner(@PathParam("id") Long ownerId){
        schoolManagementService.deleteOwner(ownerId);
    }

    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path(OWNERS)
    public List<Owner> searchOwner(@BeanParam PersonSearchParameters params){
        return schoolManagementService.searchOwners(params);
    }

    @RolesAllowed("OWNER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path(TEACHERS)
    public Teacher saveTeacher(Teacher teacher){
        return schoolManagementService.saveTeacher(teacher);
    }

    @RolesAllowed("OWNER")
    @DELETE
    @Path(TEACHERS+"/{id}")
    public void deleteTeacher(@PathParam("id") Long teacherId){
        schoolManagementService.deleteTeacher(teacherId);
    }

    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path(TEACHERS)
    public List<Teacher> searchTeacher(@BeanParam PersonSearchParameters params){
        return schoolManagementService.searchTeachers(params);
    }

    @RolesAllowed("OWNER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path(GUARDIANS)
    public Guardian saveGuardian(Guardian guardian){
        return schoolManagementService.saveGuardian(guardian);
    }

    @RolesAllowed("OWNER")
    @DELETE
    @Path(GUARDIANS+"/{id}")
    public void deleteGuardian(@PathParam("id") Long guardianId){
        schoolManagementService.deleteGuardian(guardianId);
    }

    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path(GUARDIANS)
    public List<Guardian> searchGuardians(@BeanParam PersonSearchParameters params){
        return schoolManagementService.searchGuardians(params);
    }


    @RolesAllowed("OWNER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path(STUDENTS)
    public Student saveStudent(Student student){
        return schoolManagementService.saveStudent(student);
    }

    @RolesAllowed("OWNER")
    @DELETE
    @Path(STUDENTS+"/{id}")
    public void deleteStudent(@PathParam("id") Long studentId){
        schoolManagementService.deleteStudent(studentId);
    }

    @RolesAllowed("OWNER")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path(STUDENTS)
    public List<Student> searchStudents(@BeanParam PersonSearchParameters params){
        return schoolManagementService.searchStudents(params);
    }
}
