package gr.aueb.mscis.educore.service.evaluation;

import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import gr.aueb.mscis.educore.service.factory.ServiceFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EvaluationServiceTest extends EducoreTest {
    EvaluationService evaluationService;

    @BeforeEach
    public void setup(){
        evaluationService = ServiceFactory.getEvaluationService();
    }

    @Test
    public void createEvaluationTest(){
        Student student = DataFactory.getValidStudent(true);
        Course course = DataFactory.getValidCourse(true);
        Evaluation evaluation = DataFactory.getValidEvaluation();
        evaluation.setCourse(null);
        evaluation.setStudent(null);
        evaluation = evaluationService.evaluateStudent(student.getId(), course.getId(), evaluation);

        Assertions.assertNotNull(evaluation.getId());
        Assertions.assertEquals(evaluation.getCourse().getId(),course.getId());
        Assertions.assertEquals(evaluation.getStudent().getId(),student.getId());
    }

    @Test
    public void deleteEvaluationTest(){
        Evaluation evaluation = DataFactory.getValidEvaluation(true);
        Assertions.assertNotNull(evaluation.getId());

        evaluationService.deleteEvaluation(evaluation.getId());

        Assertions.assertNull(evaluationService.findEvaluationById(evaluation.getId()));
    }

    @Test
    public void searchEvaluationTest(){
        Evaluation evaluation1 = DataFactory.getValidEvaluation(true);
        Evaluation evaluation2 = DataFactory.getValidEvaluation(true);
        Evaluation evaluation3 = DataFactory.getValidEvaluation(true);

        List<Evaluation> evaluations = evaluationService.searchEvaluations(new SearchParameters());
        Assertions.assertEquals(3,evaluationService.searchEvaluations(new SearchParameters()).size());
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.addParameter("course.id",evaluation1.getCourse().getId());

        List<Evaluation> results = evaluationService.searchEvaluations(searchParameters);

        Assertions.assertEquals(results.size(),1);
        Assertions.assertEquals(results.get(0).getCourse().getId(),evaluation1.getCourse().getId());
    }
}
