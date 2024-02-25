package gr.aueb.mscis.educore.web.school;

import gr.aueb.mscis.educore.dto.search.CourseSearchParameters;
import gr.aueb.mscis.educore.model.school.*;
import gr.aueb.mscis.educore.service.school.impl.CourseServiceImpl;
import gr.aueb.mscis.educore.web.AbstractResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static gr.aueb.mscis.educore.web.EducoreUri.*;


@Path(COURSES)
public class CourseResource extends AbstractResource {

    @Inject
    CourseServiceImpl courseService;

    @RolesAllowed("TEACHER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/")
    public Course saveCourse(Course course){
        return courseService.saveCourse(0l, course);
    }

    @RolesAllowed("TEACHER")
    @DELETE
    @Path("/{id}")
    public void deleteCourse(@PathParam("id") Long courseId){
        courseService.deleteCourse(courseId);
    }

    @RolesAllowed("TEACHER")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/")
    public List<Course> searchCourse(@BeanParam CourseSearchParameters params){
        return courseService.searchCourses(params);
    }

}
