package gr.aueb.mscis.educore.web.evaluation;

import gr.aueb.mscis.educore.dto.evaluation.EvaluationDto;
import gr.aueb.mscis.educore.dto.factory.DtoFactory;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Student;
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

import static gr.aueb.mscis.educore.web.EducoreUri.EVALUATIONS;

public class EvaluationResourceTest extends BasicWebTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(EvaluationResource.class)
                .register(new TestBinder());
    }

    @Test
    public void evaluationSearchTest(){
        DataFactory.getValidEvaluation(true);
        DataFactory.getValidEvaluation(true);
        DataFactory.getValidEvaluation(true);

        List<Evaluation> evaluations = target(EVALUATIONS)
                .request()
                .get(new GenericType<List<Evaluation>>() {});

        Assert.assertEquals(3, evaluations.size());
    }

    @Test
    public void evaluationCreateTest(){
        Student student = DataFactory.getValidStudent(true);
        Course course = DataFactory.getValidCourse(true);
        EvaluationDto evaluationDto = DtoFactory.getEvaluationDto();

        Response response = target(EVALUATIONS)
                .queryParam("studentId",student.getId())
                .queryParam("courseId",course.getId())
                .request()
                .post(Entity.entity(evaluationDto, MediaType.APPLICATION_JSON_TYPE));

        Evaluation responseData = response.readEntity(Evaluation.class);
        Assert.assertNotNull(responseData);
        Assert.assertNotNull(responseData.getId());
        Assert.assertNotNull(responseData.getGrade());
    }

    @Test
    public void evaluationDeleteTest(){
        Evaluation evaluation = DataFactory.getValidEvaluation(true);
        Assert.assertNotNull(evaluation.getId());
        target(EVALUATIONS+"/"+evaluation.getId())
                .request()
                .delete();

        List<Evaluation> evaluations = target(EVALUATIONS)
                .request()
                .get(new GenericType<List<Evaluation>>() {});

        Assert.assertEquals(0, evaluations.size());
    }
}
