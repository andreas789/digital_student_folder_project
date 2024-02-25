package gr.aueb.mscis.educore.dto.evaluation;

public class EvaluationDto {
    Double grade;
    Integer participationInClass;
    Integer cooperation;
    Integer behavior;
    Integer communication;
    Integer homework;

    public EvaluationDto() {}

    public Double getGrade() {return this.grade;}

    public Integer getParticipationInClass() {return this.participationInClass;}

    public Integer getCooperation() {return this.cooperation;}

    public Integer getBehavior() {return this.behavior;}

    public Integer getCommunication() {return this.communication;}

    public Integer getHomework() {return this.homework;}

    public void setGrade(Double grade) {this.grade = grade; }

    public void setParticipationInClass(Integer participationInClass) {this.participationInClass = participationInClass; }

    public void setCooperation(Integer cooperation) {this.cooperation = cooperation; }

    public void setBehavior(Integer behavior) {this.behavior = behavior; }

    public void setCommunication(Integer communication) {this.communication = communication; }

    public void setHomework(Integer homework) {this.homework = homework; }
}
