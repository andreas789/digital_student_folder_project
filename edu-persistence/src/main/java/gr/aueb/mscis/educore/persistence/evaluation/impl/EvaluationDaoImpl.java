package gr.aueb.mscis.educore.persistence.evaluation.impl;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.evaluation.EvaluationDao;
import org.jvnet.hk2.annotations.Service;

@Service
public class EvaluationDaoImpl extends AbstractDao<Evaluation> implements EvaluationDao {

    @Override
    public Evaluation saveEvaluation(Evaluation evaluation){
        if(!evaluation.isValidForPersistence()){
            throw new ValidationException(ExceptionMessages.INVALID_DATA);
        }
        evaluation.calculateGrade();
        return saveOrUpdate(evaluation);
    }
}
