package gr.aueb.mscis.educore.dto.factory;

import gr.aueb.mscis.educore.dto.evaluation.EvaluationDto;

public class DtoFactory {

    public static EvaluationDto getEvaluationDto(){
        EvaluationDto dto = new EvaluationDto();
        dto.setBehavior(1);
        dto.setCommunication(2);
        dto.setCooperation(3);
        dto.setHomework(4);
        dto.setParticipationInClass(5);
        return dto;
    }
}
