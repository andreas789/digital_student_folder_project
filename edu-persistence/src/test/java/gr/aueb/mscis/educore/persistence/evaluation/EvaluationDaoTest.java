package gr.aueb.mscis.educore.persistence.evaluation;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.persistence.test.EducoreTest;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.util.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvaluationDaoTest extends EducoreTest {

    EvaluationDao evaluationDao;

    @BeforeEach
    public void setup() {
        evaluationDao = DaoFactory.getEvaluationDao();
    }

    @Test
    public void createEvaluationSuccessTest() {
        Evaluation evaluation = DataFactory.getValidEvaluation();
        Evaluation createdEvaluation = evaluationDao.saveEvaluation(evaluation);
        Assertions.assertNotNull(createdEvaluation.getId());
        Assertions.assertEquals(createdEvaluation.getGrade(), 3);
    }

    @Test
    public void createEvaluationFailTest() {
        Evaluation evaluation = DataFactory.getValidEvaluation();
        evaluation.setHomework(null);
        Assertions.assertThrows(ValidationException.class, () -> evaluationDao.saveEvaluation(evaluation), ExceptionMessages.INVALID_DATA);
    }
}
