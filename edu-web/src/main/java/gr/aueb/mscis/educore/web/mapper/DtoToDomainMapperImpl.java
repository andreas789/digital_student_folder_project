package gr.aueb.mscis.educore.web.mapper;

import gr.aueb.mscis.educore.dto.evaluation.EvaluationDto;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;

public class DtoToDomainMapperImpl extends DtoToDomainMapper{


    @Override
    public Evaluation toDomainEvaluation(EvaluationDto evaluationDto) {
        Evaluation evaluation = new Evaluation();
        evaluation.setCooperation(evaluationDto.getCooperation());
        evaluation.setHomework(evaluationDto.getHomework());
        evaluation.setCommunication(evaluationDto.getCommunication());
        evaluation.setBehavior(evaluationDto.getBehavior());
        evaluation.setParticipationInClass(evaluationDto.getParticipationInClass());
        evaluation.setGrade(evaluationDto.getGrade());
        return evaluation;
    }
}
