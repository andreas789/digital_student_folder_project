package gr.aueb.mscis.educore.web.evaluation;

import gr.aueb.mscis.educore.dto.evaluation.EvaluationDto;
import gr.aueb.mscis.educore.dto.search.EvaluationSearchParameters;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.service.evaluation.impl.EvaluationServiceImpl;
import gr.aueb.mscis.educore.web.AbstractResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static gr.aueb.mscis.educore.web.EducoreUri.*;

@Path(EVALUATIONS)
public class EvaluationResource extends AbstractResource {

    @Inject
    EvaluationServiceImpl evaluationService;

    @RolesAllowed("TEACHER")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Evaluation> searchEvaluations(EvaluationSearchParameters params){
        return evaluationService.searchEvaluations(params);
    }

    @RolesAllowed("TEACHER")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Evaluation evaluateStudent(@QueryParam("studentId") Long studentId, @QueryParam("courseId") Long courseId, EvaluationDto evaluationDto){
        return evaluationService.evaluateStudent(studentId,courseId,mapper.toDomainEvaluation(evaluationDto));
    }

    @RolesAllowed("TEACHER")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deleteEvaluation(@PathParam("id")  Long evaluationId){
        evaluationService.deleteEvaluation(evaluationId);
    }
}
