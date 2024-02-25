package gr.aueb.mscis.educore.persistence.evaluation;

import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface EvaluationDao extends GenericDao<Evaluation> {

    Evaluation saveEvaluation(Evaluation evaluation);
}
