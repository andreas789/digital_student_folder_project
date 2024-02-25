package gr.aueb.mscis.educore.model.evaluation;

import gr.aueb.mscis.educore.model.core.CoreEntity;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Student;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "evaluations")
public class Evaluation extends CoreEntity {
    Double grade;
    Integer participationInClass;
    Integer cooperation;
    Integer behavior;
    Integer communication;
    Integer homework;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Evaluation() {}

    public boolean isValidForPersistence() {
        return Objects.nonNull(student) &&
                Objects.nonNull(course) &&
                Objects.nonNull(homework) &&
                Objects.nonNull(communication) &&
                Objects.nonNull(behavior) &&
                Objects.nonNull(cooperation) &&
                Objects.nonNull(participationInClass);
    }

    public void calculateGrade(){
        Integer total = homework + communication + behavior + cooperation + participationInClass;
        this.setGrade(Double.parseDouble(total+"")/5d);
    }

    public Double getGrade() {return this.grade;}

    public Integer getParticipationInClass() {return this.participationInClass;}

    public Integer getCooperation() {return this.cooperation;}

    public Integer getBehavior() {return this.behavior;}

    public Integer getCommunication() {return this.communication;}

    public Integer getHomework() {return this.homework;}

    public Course getCourse() {return this.course;}

    public Student getStudent() {return this.student;}

    public void setGrade(Double grade) {this.grade = grade; }

    public void setParticipationInClass(Integer participationInClass) {this.participationInClass = participationInClass; }

    public void setCooperation(Integer cooperation) {this.cooperation = cooperation; }

    public void setBehavior(Integer behavior) {this.behavior = behavior; }

    public void setCommunication(Integer communication) {this.communication = communication; }

    public void setHomework(Integer homework) {this.homework = homework; }

    public void setCourse(Course course) {this.course = course; }

    public void setStudent(Student student) {this.student = student; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Evaluation)) return false;
        final Evaluation other = (Evaluation) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$grade = this.getGrade();
        final Object other$grade = other.getGrade();
        if (this$grade == null ? other$grade != null : !this$grade.equals(other$grade)) return false;
        final Object this$participationInClass = this.getParticipationInClass();
        final Object other$participationInClass = other.getParticipationInClass();
        if (this$participationInClass == null ? other$participationInClass != null : !this$participationInClass.equals(other$participationInClass)) return false;
        final Object this$cooperation = this.getCooperation();
        final Object other$cooperation = other.getCooperation();
        if (this$cooperation == null ? other$cooperation != null : !this$cooperation.equals(other$cooperation)) return false;
        final Object this$behavior = this.getBehavior();
        final Object other$behavior = other.getBehavior();
        if (this$behavior == null ? other$behavior != null : !this$behavior.equals(other$behavior)) return false;
        final Object this$communication = this.getCommunication();
        final Object other$communication = other.getCommunication();
        if (this$communication == null ? other$communication != null : !this$communication.equals(other$communication)) return false;
        final Object this$homework = this.getHomework();
        final Object other$homework = other.getHomework();
        if (this$homework == null ? other$homework != null : !this$homework.equals(other$homework)) return false;
        final Object this$course = this.getCourse();
        final Object other$course = other.getCourse();
        if (this$course == null ? other$course != null : !this$course.equals(other$course)) return false;
        final Object this$student = this.getStudent();
        final Object other$student = other.getStudent();
        if (this$student == null ? other$student != null : !this$student.equals(other$student)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Evaluation;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $grade = this.getGrade();
        result = result * PRIME + ($grade == null ? 43 : $grade.hashCode());
        final Object $participationInClass = this.getParticipationInClass();
        result = result * PRIME + ($participationInClass == null ? 43 : $participationInClass.hashCode());
        final Object $cooperation = this.getCooperation();
        result = result * PRIME + ($cooperation == null ? 43 : $cooperation.hashCode());
        final Object $behavior = this.getBehavior();
        result = result * PRIME + ($behavior == null ? 43 : $behavior.hashCode());
        final Object $communication = this.getCommunication();
        result = result * PRIME + ($communication == null ? 43 : $communication.hashCode());
        final Object $homework = this.getHomework();
        result = result * PRIME + ($homework == null ? 43 : $homework.hashCode());
        final Object $course = this.getCourse();
        result = result * PRIME + ($course == null ? 43 : $course.hashCode());
        final Object $student = this.getStudent();
        result = result * PRIME + ($student == null ? 43 : $student.hashCode());
        return result;
    }
}
