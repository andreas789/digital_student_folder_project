package gr.aueb.mscis.educore.web.mapper;

import gr.aueb.mscis.educore.dto.evaluation.EvaluationDto;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;

public abstract class DtoToDomainMapper {

    public abstract Evaluation toDomainEvaluation(EvaluationDto studentDto);

}
