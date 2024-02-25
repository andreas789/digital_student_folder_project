package gr.aueb.mscis.educore.service.evaluation;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;

import java.util.List;

public interface EvaluationService {
    Evaluation evaluateStudent(Long studentId, Long courseId, Evaluation evaluation);

    void deleteEvaluation(Long evaluationId);

    List<Evaluation> searchEvaluations(SearchParameters params);

    Evaluation findEvaluationById(long id);
}
