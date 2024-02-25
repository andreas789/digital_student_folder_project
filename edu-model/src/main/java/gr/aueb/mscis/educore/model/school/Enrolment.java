package gr.aueb.mscis.educore.model.school;

import gr.aueb.mscis.educore.model.core.CoreEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "enrolments")
public class Enrolment extends CoreEntity {
    LocalDate registrationDate;
    String registrationNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student;

    public Enrolment() {}

    public LocalDate getRegistrationDate() {return this.registrationDate;}

    public String getRegistrationNumber() {return this.registrationNumber;}

    public Course getCourse() {return this.course;}

    public Student getStudent() {return this.student;}

    public void setRegistrationDate(LocalDate registrationDate) {this.registrationDate = registrationDate; }

    public void setRegistrationNumber(String registrationNumber) {this.registrationNumber = registrationNumber; }

    public void setCourse(Course course) {this.course = course; }

    public void setStudent(Student student) {this.student = student; }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Enrolment)) return false;
        final Enrolment other = (Enrolment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$registrationDate = this.getRegistrationDate();
        final Object other$registrationDate = other.getRegistrationDate();
        if (this$registrationDate == null ? other$registrationDate != null : !this$registrationDate.equals(other$registrationDate)) return false;
        final Object this$registrationNumber = this.getRegistrationNumber();
        final Object other$registrationNumber = other.getRegistrationNumber();
        if (this$registrationNumber == null ? other$registrationNumber != null : !this$registrationNumber.equals(other$registrationNumber)) return false;
        final Object this$course = this.getCourse();
        final Object other$course = other.getCourse();
        if (this$course == null ? other$course != null : !this$course.equals(other$course)) return false;
        final Object this$student = this.getStudent();
        final Object other$student = other.getStudent();
        if (this$student == null ? other$student != null : !this$student.equals(other$student)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {return other instanceof Enrolment;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $registrationDate = this.getRegistrationDate();
        result = result * PRIME + ($registrationDate == null ? 43 : $registrationDate.hashCode());
        final Object $registrationNumber = this.getRegistrationNumber();
        result = result * PRIME + ($registrationNumber == null ? 43 : $registrationNumber.hashCode());
        final Object $course = this.getCourse();
        result = result * PRIME + ($course == null ? 43 : $course.hashCode());
        final Object $student = this.getStudent();
        result = result * PRIME + ($student == null ? 43 : $student.hashCode());
        return result;
    }
}

